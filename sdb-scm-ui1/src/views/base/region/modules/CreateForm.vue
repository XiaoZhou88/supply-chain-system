<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="库区编码" prop="regionCode" >
        <a-input v-model="form.regionCode" placeholder="请输入库区编码" />
      </a-form-model-item>
      <a-form-model-item label="库区名称" prop="regionName" >
        <a-input v-model="form.regionName" placeholder="请输入库区名称" />
      </a-form-model-item>
      <a-form-model-item label="所属仓库" prop="depositId" >
        <a-select v-model="form.depositId" style="width: 120px">
          <a-select-option v-for="(deposit, index ) in depositList" :key="index" :value="deposit.depositId">
            {{ deposit.depositName }}
          </a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标志" prop="delFlag" v-if="formType === 1">
        <a-input v-model="form.delFlag" placeholder="请输入删除标志" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户ID" prop="tanentId" >
        <a-input v-model="form.tanentId" placeholder="请输入租户ID" />
      </a-form-model-item>
      <div class="bottom-control">
        <a-space>
          <a-button type="primary" @click="submitForm">
            保存
          </a-button>
          <a-button type="dashed" @click="cancel">
            取消
          </a-button>
        </a-space>
      </div>
    </a-form-model>
  </a-drawer>
</template>

<script>
import { getRegion, addRegion, updateRegion } from '@/api/base/storeregion'
import { listDeposit } from '@/api/base/deposit'

export default {
  name: 'CreateForm',
  props: {
  },
  components: {
  },
  data () {
    return {
      loading: false,
      formTitle: '',
      depositList: null,
      query: {
        depositId: null,
        depositName: null
      },
      // 表单参数
      form: {
        depositRegionId: null,
        regionCode: null,
        regionName: null,
        depositId: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tanentId: null
      },
      // 1增加,2修改
      formType: 1,
      open: false,
      rules: {
      }
    }
  },
  filters: {
  },
  created () {
    listDeposit(this.query).then(response => {
      this.depositList = response.rows
    })
  },
  computed: {
  },
  watch: {
  },
  mounted () {
  },
  methods: {
    onClose () {
      this.open = false
    },
    // 取消按钮
    cancel () {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset () {
      this.formType = 1
      this.form = {
        depositRegionId: null,
        regionCode: null,
        regionName: null,
        depositId: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tanentId: null
      }
    },
    /** 新增按钮操作 */
    handleAdd (row) {
      this.reset()
      this.formType = 1
      this.open = true
      this.formTitle = '添加'
    },
    /** 修改按钮操作 */
    handleUpdate (row, ids) {
      this.reset()
      this.formType = 2
      const depositRegionId = row ? row.depositRegionId : ids
      getRegion(depositRegionId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.depositRegionId !== undefined && this.form.depositRegionId !== null) {
            updateRegion(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addRegion(this.form).then(response => {
              this.$message.success(
                '新增成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          }
        } else {
          return false
        }
      })
    }
  }
}
</script>
