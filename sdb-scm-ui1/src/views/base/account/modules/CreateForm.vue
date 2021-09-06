<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="名称" prop="accountName" >
        <a-input v-model="form.accountName" placeholder="请输入名称" />
      </a-form-model-item>
      <a-form-model-item label="编号" prop="serialNo" >
        <a-input v-model="form.serialNo" placeholder="请输入编号" />
      </a-form-model-item>
      <a-form-model-item label="期初金额" prop="initialAmount" >
        <a-input v-model="form.initialAmount" placeholder="请输入期初金额" />
      </a-form-model-item>
      <a-form-model-item label="当前余额" prop="currentAmount" >
        <a-input v-model="form.currentAmount" placeholder="请输入当前余额" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入备注" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="是否默认" prop="isDefault" >
        <a-input v-model="form.isDefault" placeholder="请输入是否默认" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户id" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户id" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标记" prop="deleteFlag" >
        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />
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
import { getAccount, addAccount, updateAccount } from '@/api/base/account'

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
        accountId: null,
        accountName: null,
        serialNo: null,
        initialAmount: null,
        currentAmount: null,
        remark: null,
        isDefault: null,
        tenantId: null,
        deleteFlag: null
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
        accountId: null,
        accountName: null,
        serialNo: null,
        initialAmount: null,
        currentAmount: null,
        remark: null,
        isDefault: null,
        tenantId: null,
        deleteFlag: null
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
      const accountId = row ? row.accountId : ids
      getAccount(accountId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.accountId !== undefined && this.form.accountId !== null) {
            updateAccount(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addAccount(this.form).then(response => {
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
