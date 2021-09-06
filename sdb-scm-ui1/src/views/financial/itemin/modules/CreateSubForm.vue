<template>
  <!-- 增加修改 -->
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>收入款细目</b>
    </a-divider>
    <a-form-model ref="form" :model="form">
      <a-form-model-item label="账户Id" prop="accountId">
        <a-input v-model="form.accountId" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="收支项目Id" prop="inOutItemId">
        <a-input v-model="form.inOutItemId" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="单据id" prop="billId">
        <a-input v-model="form.billId" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="应收欠款" prop="needDebt">
        <a-input v-model="form.needDebt" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="已收欠款" prop="finishDebt">
        <a-input v-model="form.finishDebt" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="单项金额" prop="eachAmount">
        <a-input v-model="form.eachAmount" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="单据备注" prop="remark">
        <a-input v-model="form.remark" placeholder="请输入" />
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

export default {
  name: 'CreateSubForm',
  props: {
  },
  components: {
  },
  data () {
    return {
      formTitle: '增加',
      // 表单参数
      form: {
        accountId: undefined,
        inOutItemId: undefined,
        billId: undefined,
        needDebt: undefined,
        finishDebt: undefined,
        eachAmount: undefined,
        remark: undefined,
        tenantId: undefined,
        deleteFlag: undefined
      },
      open: false
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
      this.form = {
        accountId: undefined,
        inOutItemId: undefined,
        billId: undefined,
        needDebt: undefined,
        finishDebt: undefined,
        eachAmount: undefined,
        remark: undefined,
        tenantId: undefined,
        deleteFlag: undefined
      }
    },
     /** 新增按钮操作 */
    handleAdd () {
      this.open = true
      this.reset()
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$emit('add', this.form)
      this.open = false
    }
  }
}
</script>
