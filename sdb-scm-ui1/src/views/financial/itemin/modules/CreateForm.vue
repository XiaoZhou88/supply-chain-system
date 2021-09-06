<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="单位Id" prop="organId" >
        <a-input v-model="form.organId" placeholder="请输入单位Id(收款/付款单位)" />
      </a-form-model-item>
      <a-form-model-item label="经手人id" prop="agentId" >
        <a-input v-model="form.agentId" placeholder="请输入经手人id" />
      </a-form-model-item>
      <a-form-model-item label="操作员" prop="creator" >
        <a-input v-model="form.creator" placeholder="请输入操作员" />
      </a-form-model-item>
      <a-form-model-item label="变动金额" prop="changeAmount" >
        <a-input v-model="form.changeAmount" placeholder="请输入变动金额(优惠/收款/付款/实付)" />
      </a-form-model-item>
      <a-form-model-item label="合计金额" prop="totalPrice" >
        <a-input v-model="form.totalPrice" placeholder="请输入合计金额"/>
      </a-form-model-item>
      <a-form-model-item label="账户" prop="accountId" >
        <a-input v-model="form.accountId" placeholder="请输入账户(收款/付款)" />
      </a-form-model-item>
      <a-form-model-item label="单据编号" prop="billNo" >
        <a-input v-model="form.billNo" placeholder="请输入单据编号" />
      </a-form-model-item>
      <a-form-model-item label="单据日期" prop="billTime" >
        <a-date-picker style="width: 100%" v-model="form.billTime" format="YYYY-MM-DD HH:mm:ss" allow-clear/>
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入备注" />
      </a-form-model-item>
      <a-form-model-item label="附件名称" prop="fileName" >
        <a-input v-model="form.fileName" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
<!--      <a-form-model-item label="租户id" prop="tenantId" >-->
<!--        <a-input v-model="form.tenantId" placeholder="请输入租户id" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="删除标记" prop="deleteFlag" >-->
<!--        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />-->
<!--      </a-form-model-item>-->
      <a-divider orientation="left">
        <b>收入单细目</b>
      </a-divider>
      <sub-table ref="subTable" :list="subList" @add="handleAdderpAccountItem" @delete="handleDeleteerpAccountItem" />
      <p>当前存在 {{ subList.length }} 条信息</p>
      <a-button type="dashed" @click="$refs.subTable.show()">
        详情
      </a-button>
      <br>
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
import { getItemin, addItemin, updateItemin } from '@/api/financial/itemin'
import SubTable from './SubTable'

export default {
  name: 'CreateForm',
  props: {
    typeOptions: {
      type: Array,
      required: true
    }
  },
  components: {
    SubTable
  },
  data () {
    return {
      loading: false,
      subList: [],
      sumPrice: '0',
      formTitle: '',
      // 表单参数
      form: {
        accountHeadId: null,
        type: '0',
        organId: null,
        agentId: null,
        creator: null,
        changeAmount: null,
        totalPrice: null,
        accountId: null,
        billNo: null,
        billTime: null,
        remark: null,
        fileName: null,
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
      this.subList = []
    },
    // 取消按钮
    cancel () {
      this.open = false
      this.reset()
      this.subList = []
    },
    // 表单重置
    reset () {
      this.formType = 1
      this.form = {
        accountHeadId: null,
        type: '0',
        organId: null,
        agentId: null,
        creator: null,
        changeAmount: null,
        totalPrice: null,
        accountId: null,
        billNo: null,
        billTime: null,
        remark: null,
        fileName: null,
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
    /** 新增子项操作 */
    handleAdderpAccountItem (row) {
      this.subList.push(row)
    },
    /** 删除子项操作 */
    handleDeleteerpAccountItem (index, indexs) {
      if (index !== undefined) {
        this.subList.splice(index, 1)
        return
      }
      indexs.forEach(item => {
        this.subList.splice(item, 1)
      })
    },
    /** 修改按钮操作 */
    handleUpdate (row, ids) {
      this.reset()
      this.formType = 2
      const accountHeadId = row ? row.accountHeadId : ids
      getItemin(accountHeadId).then(response => {
        this.form = response.data
        this.subList = response.data.erpAccountItemList
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.form.erpAccountItemList = this.subList
          if (this.form.accountHeadId !== undefined && this.form.accountHeadId !== null) {
            updateItemin(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addItemin(this.form).then(response => {
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
