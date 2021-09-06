<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="库位尺寸名称" prop="storesizeName" >
        <a-input v-model="form.storesizeName" placeholder="请输入库位尺寸名称" />
      </a-form-model-item>
      <a-form-model-item label="库位长度" prop="length" >
        <a-input v-model="form.length" placeholder="请输入库位长度(单位:毫米)" />
      </a-form-model-item>
      <a-form-model-item label="库位宽度" prop="width" >
        <a-input v-model="form.width" placeholder="请输入库位宽度(单位:毫米)" />
      </a-form-model-item>
      <a-form-model-item label="库位高度" prop="height" >
        <a-input v-model="form.height" placeholder="请输入库位高度(单位:毫米)" />
      </a-form-model-item>
      <a-form-model-item label="最大重量" prop="maxWeight" >
        <a-input v-model="form.maxWeight" placeholder="请输入最大重量(单位:千克)" />
      </a-form-model-item>
      <a-form-model-item label="最大托盘" prop="maxTray" >
        <a-input v-model="form.maxTray" placeholder="请输入最大托盘(单位:件)" />
      </a-form-model-item>
      <a-form-model-item label="最大体积" prop="maxVolume" >
        <a-input v-model="form.maxVolume" placeholder="请输入最大体积(单位:立方毫米)" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标志" prop="delFlag" v-if="formType === 1">
        <a-input v-model="form.delFlag" placeholder="请输入删除标志" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户ID" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户ID" />
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
import { getStoresize, addStoresize, updateStoresize } from '@/api/base/storesize'

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
      // 表单参数
      form: {
        storesizeId: null,
        storesizeName: null,
        length: null,
        width: null,
        height: null,
        maxWeight: null,
        maxTray: null,
        maxVolume: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tenantId: null
      },
      // 1增加,2修改
      formType: 1,
      open: false,
      rules: {
        tenantId: [
          { required: true, message: '租户ID不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  filters: {
  },
  created () {
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
        storesizeId: null,
        storesizeName: null,
        length: null,
        width: null,
        height: null,
        maxWeight: null,
        maxTray: null,
        maxVolume: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tenantId: null
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
      const storesizeId = row ? row.storesizeId : ids
      getStoresize(storesizeId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.storesizeId !== undefined && this.form.storesizeId !== null) {
            updateStoresize(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addStoresize(this.form).then(response => {
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
