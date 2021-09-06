<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="产品表id" prop="materialId" >
        <a-input v-model="form.materialId" placeholder="请输入产品表id" />
      </a-form-model-item>
      <a-form-model-item label="序列号" prop="serialNumber" >
        <a-input v-model="form.serialNumber" placeholder="请输入序列号" />
      </a-form-model-item>
      <a-form-model-item label="是否卖出" prop="isSell" >
        <a-input v-model="form.isSell" placeholder="请输入是否卖出，0未卖出，1卖出" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标记" prop="deleteFlag" >
        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />
      </a-form-model-item>
      <a-form-model-item label="创建人" prop="creator" >
        <a-input v-model="form.creator" placeholder="请输入创建人" />
      </a-form-model-item>
      <a-form-model-item label="更新人" prop="updater" >
        <a-input v-model="form.updater" placeholder="请输入更新人" />
      </a-form-model-item>
      <a-form-model-item label="进销存单据主表id" prop="jxcHeadId" >
        <a-input v-model="form.jxcHeadId" placeholder="请输入进销存单据主表id，用于跟踪序列号流向" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户id" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户id" />
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
import { getSerialnumber, addSerialnumber, updateSerialnumber } from '@/api/material/serialnumber'

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
        serialId: null,
        materialId: null,
        serialNumber: null,
        isSell: null,
        remark: null,
        deleteFlag: null,
        createTime: null,
        creator: null,
        updateTime: null,
        updater: null,
        jxcHeadId: null,
        tenantId: null
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
        serialId: null,
        materialId: null,
        serialNumber: null,
        isSell: null,
        remark: null,
        deleteFlag: null,
        createTime: null,
        creator: null,
        updateTime: null,
        updater: null,
        jxcHeadId: null,
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
      const serialId = row ? row.serialId : ids
      getSerialnumber(serialId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.serialId !== undefined && this.form.serialId !== null) {
            updateSerialnumber(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addSerialnumber(this.form).then(response => {
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
