<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="类型(出库/入库)" prop="type" >
        <a-select placeholder="请选择类型(出库/入库)" v-model="form.type">
          <a-select-option v-for="(d, index) in typeOptions" :key="index" :value="d.dictValue" >{{ d.dictLabel }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="出入库分类" prop="subType" >
        <a-select placeholder="请选择出入库分类" v-model="form.subType">
          <a-select-option v-for="(d, index) in subTypeOptions" :key="index" :value="d.dictValue" >{{ d.dictLabel }}</a-select-option>
        </a-select>
      </a-form-model-item>
<!--      <a-form-model-item label="初始票据号" prop="defaultNumber" >-->
<!--        <a-input v-model="form.defaultNumber" placeholder="请输入初始票据号" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="单据编号" prop="number" >
        <a-input v-model="form.number" placeholder="请输入票据号" ></a-input>
      </a-form-model-item>
      <a-form-model-item label="单据时间" prop="operTime" >
        <a-date-picker style="width: 100%" v-model="form.operTime" format="YYYY-MM-DD HH:mm:ss" allow-clear/>
      </a-form-model-item>
      <a-form-model-item label="供应商id" prop="organId" >
        <a-select v-model="form.organId" placeholder="请输入供应商id">
          <a-select-option v-for="(supplier, index) in supplierList" :key="index" :value="supplier.supplierId" >
            {{supplier.supplierName}}
          </a-select-option>
        </a-select>
      </a-form-model-item>
<!--      <a-form-model-item label="采购/领料-经手人id" prop="agentId" >-->
<!--        <a-input v-model="form.agentId" placeholder="请输入采购/领料-经手人id" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="操作员" prop="creator" >
        <a-select v-model="form.creator"  placeholder="请输入操作员">
          <a-select-option v-for="(user , index) in userList" :key="index" :value="user.userId">
            {{user.nickName}}
          </a-select-option>
        </a-select>
      </a-form-model-item>
<!--      <a-form-model-item label="账户id" prop="accountId" >-->
<!--        <a-input v-model="form.accountId" placeholder="请输入账户id" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="变动金额(收款/付款)" prop="changeAmount" >-->
<!--        <a-input v-model="form.changeAmount" placeholder="请输入变动金额(收款/付款)" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="合计金额" prop="totalPrice" >-->
<!--        <a-input v-model="form.totalPrice" placeholder="请输入合计金额" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="付款类型(现金、记账等)" prop="payType" >-->
<!--        <a-select placeholder="请选择付款类型(现金、记账等)" v-model="form.payType">-->
<!--          <a-select-option value="" >请选择字典生成</a-select-option>-->
<!--        </a-select>-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="单据类型" prop="billType" >-->
<!--        <a-select placeholder="请选择单据类型" v-model="form.billType">-->
<!--          <a-select-option value="" >请选择字典生成</a-select-option>-->
<!--        </a-select>-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="备注" prop="remark" >-->
<!--        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="附件名称" prop="fileName" >-->
<!--        <a-input v-model="form.fileName" placeholder="请输入内容" type="textarea" allow-clear />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="业务员" prop="salesMan" >-->
<!--        <a-input v-model="form.salesMan" placeholder="请输入业务员" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="多账户ID列表" prop="accountIdList" >-->
<!--        <a-input v-model="form.accountIdList" placeholder="请输入多账户ID列表" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="多账户金额列表" prop="accountMoneyList" >-->
<!--        <a-input v-model="form.accountMoneyList" placeholder="请输入多账户金额列表" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="优惠率" prop="discount" >-->
<!--        <a-input v-model="form.discount" placeholder="请输入优惠率" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="优惠金额" prop="discountMoney" >-->
<!--        <a-input v-model="form.discountMoney" placeholder="请输入优惠金额" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="优惠后金额" prop="discountLastMoney" >-->
<!--        <a-input v-model="form.discountLastMoney" placeholder="请输入优惠后金额" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="销售或采购费用合计" prop="otherMoney" >
        <a-input v-model="form.otherMoney" placeholder="请输入销售或采购费用合计" />
      </a-form-model-item>
<!--      <a-form-model-item label="销售或采购费用涉及项目Id数组" prop="otherMoneyList" >-->
<!--        <a-input v-model="form.otherMoneyList" placeholder="请输入销售或采购费用涉及项目Id数组" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="销售或采购费用涉及项目" prop="otherMoneyItem" >-->
<!--        <a-input v-model="form.otherMoneyItem" placeholder="请输入销售或采购费用涉及项目" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="结算天数" prop="accountDay" >-->
<!--        <a-input v-model="form.accountDay" placeholder="请输入结算天数" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="状态，0未审核、1已审核、2已转采购|销售" prop="status" >
        <a-radio-group v-model="form.status" button-style="solid">
          <a-radio-button v-for="(d, index) in statusOptions" :key="index" :value="d.dictValue">{{ d.dictLabel }}</a-radio-button>
        </a-radio-group>
      </a-form-model-item>
<!--      <a-form-model-item label="关联订单号" prop="linkNumber" >-->
<!--        <a-input v-model="form.linkNumber" placeholder="请输入关联订单号" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="租户id" prop="tenantId" >-->
<!--        <a-input v-model="form.tenantId" placeholder="请输入租户id" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="删除标记，0未删除，1删除" prop="deleteFlag" >-->
<!--        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />-->
<!--      </a-form-model-item>-->
      <a-divider orientation="left">
        <b>采购单细目</b>
      </a-divider>
      <sub-table ref="subTable" :list="subList" @add="handleAdderpJxcItem" @delete="handleDeleteerpJxcItem" />
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
import { getPurchaseorder, addPurchaseorder, updatePurchaseorder } from '@/api/purchase/purchaseorder'
import SubTable from './SubTable'
import { updateBillno, getBillno } from '@/api/base/billno'
import { listSupplier } from '@/api/base/supplier'
import { listUser } from '@/api/system/user'
const billData = {
  seqName: 'bill_number_seq',
  minValue: '1',
  max_value: '999999999999999999',
  current_val: '2',
  increment_val: '1'
}

export default {
  name: 'CreateForm',
  props: {
    typeOptions: {
      type: Array,
      required: true
    },
    subTypeOptions: {
      type: Array,
      required: true
    },
    statusOptions: {
      type: Array,
      required: true
    }
  },
  components: {
    SubTable
  },
  data () {
    return {
      // 操作员数据
      userList: null,
      loading: false,
      subList: [],
      supplierList: null,
      formTitle: '',
      // // 取单据编号
      currentBillNo: undefined,
      // 表单参数
      query2: {
        userId: null,
        nickName: null
      },
      query: {
        supplierId: null,
        supplierName: null,
        type: '0'
      },
      form: {
        jxcHeadId: null,
        type: null,
        subType: null,
        defaultNumber: null,
        number: null,
        createTime: null,
        operTime: null,
        organId: null,
        agentId: null,
        creator: null,
        accountId: null,
        changeAmount: null,
        totalPrice: null,
        payType: null,
        billType: null,
        remark: null,
        fileName: null,
        salesMan: null,
        accountIdList: null,
        accountMoneyList: null,
        discount: null,
        discountMoney: null,
        discountLastMoney: null,
        otherMoney: null,
        otherMoneyList: null,
        otherMoneyItem: null,
        accountDay: null,
        status: '0',
        linkNumber: null,
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
    this.getBillCurrentNo()
    listSupplier(this.query).then(response => {
      this.supplierList = response.rows
    })
    listUser(this.query2).then(response => {
      this.userList = response.rows
    })
  },
  computed: {
  },
  watch: {
  },
  mounted () {
  },
  methods: {
    // 获取单据编号
    getBillCurrentNo () {
      updateBillno(billData)
      getBillno('bill_number_seq').then(response => {
        var data = response.data
        this.currentBillNo = '00000' + data.currentVal
      })
    },
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
        jxcHeadId: null,
        type: null,
        subType: null,
        defaultNumber: null,
        number: null,
        createTime: null,
        operTime: null,
        organId: null,
        agentId: null,
        creator: null,
        accountId: null,
        changeAmount: null,
        totalPrice: null,
        payType: null,
        billType: null,
        remark: null,
        fileName: null,
        salesMan: null,
        accountIdList: null,
        accountMoneyList: null,
        discount: null,
        discountMoney: null,
        discountLastMoney: null,
        otherMoney: null,
        otherMoneyList: null,
        otherMoneyItem: null,
        accountDay: null,
        status: '0',
        linkNumber: null,
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
      this.form.number = this.currentBillNo
    },
    /** 新增子项操作 */
    handleAdderpJxcItem (row) {
      this.subList.push(row)
    },
    /** 删除子项操作 */
    handleDeleteerpJxcItem (index, indexs) {
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
      const jxcHeadId = row ? row.jxcHeadId : ids
      getPurchaseorder(jxcHeadId).then(response => {
        this.form = response.data
        this.subList = response.data.erpJxcItemList
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.form.erpJxcItemList = this.subList
          if (this.form.jxcHeadId !== undefined && this.form.jxcHeadId !== null) {
            updatePurchaseorder(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addPurchaseorder(this.form).then(response => {
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
