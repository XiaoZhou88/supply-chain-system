<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="供应商名称" prop="supplierName" >
        <a-input v-model="form.supplierName" placeholder="请输入供应商名称" />
      </a-form-model-item>
      <a-form-model-item label="联系人" prop="contacts" >
        <a-input v-model="form.contacts" placeholder="请输入联系人" />
      </a-form-model-item>
      <a-form-model-item label="联系电话" prop="phoneNum" >
        <a-input v-model="form.phoneNum" placeholder="请输入联系电话" />
      </a-form-model-item>
      <a-form-model-item label="电子邮箱" prop="email" >
        <a-input v-model="form.email" placeholder="请输入电子邮箱" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="description" >
        <a-input v-model="form.description" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="是否系统自带" prop="isystem" >
        <a-input v-model="form.isystem" placeholder="请输入是否系统自带 0==系统 1==非系统" />
      </a-form-model-item>
      <a-form-model-item label="启用" prop="enabled" >
        <a-input v-model="form.enabled" placeholder="请输入启用" />
      </a-form-model-item>
      <a-form-model-item label="预收款" prop="advanceIn" >
        <a-input v-model="form.advanceIn" placeholder="请输入预收款" />
      </a-form-model-item>
      <a-form-model-item label="期初应收" prop="beginNeedGet" >
        <a-input v-model="form.beginNeedGet" placeholder="请输入期初应收" />
      </a-form-model-item>
      <a-form-model-item label="期初应付" prop="beginNeedPay" >
        <a-input v-model="form.beginNeedPay" placeholder="请输入期初应付" />
      </a-form-model-item>
      <a-form-model-item label="累计应收" prop="allNeedGet" >
        <a-input v-model="form.allNeedGet" placeholder="请输入累计应收" />
      </a-form-model-item>
      <a-form-model-item label="累计应付" prop="allNeedPay" >
        <a-input v-model="form.allNeedPay" placeholder="请输入累计应付" />
      </a-form-model-item>
      <a-form-model-item label="传真" prop="fax" >
        <a-input v-model="form.fax" placeholder="请输入传真" />
      </a-form-model-item>
      <a-form-model-item label="手机" prop="telephone" >
        <a-input v-model="form.telephone" placeholder="请输入手机" />
      </a-form-model-item>
      <a-form-model-item label="地址" prop="address" >
        <a-input v-model="form.address" placeholder="请输入地址" />
      </a-form-model-item>
      <a-form-model-item label="纳税人识别号" prop="taxNum" >
        <a-input v-model="form.taxNum" placeholder="请输入纳税人识别号" />
      </a-form-model-item>
      <a-form-model-item label="开户行" prop="bankName" >
        <a-input v-model="form.bankName" placeholder="请输入开户行" />
      </a-form-model-item>
      <a-form-model-item label="账号" prop="accountNumber" >
        <a-input v-model="form.accountNumber" placeholder="请输入账号" />
      </a-form-model-item>
      <a-form-model-item label="税率" prop="taxRate" >
        <a-input v-model="form.taxRate" placeholder="请输入税率" />
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
import { getSupplier, addSupplier, updateSupplier } from '@/api/base/supplier'

export default {
  name: 'CreateForm',
  props: {
    typeOptions: {
      type: Array,
      required: true
    }
  },
  components: {
  },
  data () {
    return {
      loading: false,
      formTitle: '',
      // 表单参数
      form: {
        supplierId: null,
        supplierName: null,
        contacts: null,
        phoneNum: null,
        email: null,
        description: null,
        isystem: null,
        type: '0',
        enabled: null,
        advanceIn: null,
        beginNeedGet: null,
        beginNeedPay: null,
        allNeedGet: null,
        allNeedPay: null,
        fax: null,
        telephone: null,
        address: null,
        taxNum: null,
        bankName: null,
        accountNumber: null,
        taxRate: null,
        tenantId: null,
        deleteFlag: null
      },
      // 1增加,2修改
      formType: 1,
      open: false,
      rules: {
        supplierName: [
          { required: true, message: '供应商名称不能为空', trigger: 'blur' }
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
        supplierId: null,
        supplierName: null,
        contacts: null,
        phoneNum: null,
        email: null,
        description: null,
        isystem: null,
        type: '0',
        enabled: null,
        advanceIn: null,
        beginNeedGet: null,
        beginNeedPay: null,
        allNeedGet: null,
        allNeedPay: null,
        fax: null,
        telephone: null,
        address: null,
        taxNum: null,
        bankName: null,
        accountNumber: null,
        taxRate: null,
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
      const supplierId = row ? row.supplierId : ids
      getSupplier(supplierId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.supplierId !== undefined && this.form.supplierId !== null) {
            updateSupplier(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addSupplier(this.form).then(response => {
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
