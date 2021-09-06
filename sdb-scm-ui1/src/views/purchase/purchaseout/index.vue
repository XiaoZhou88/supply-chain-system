<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="类型(出库/入库)" prop="type">
                <a-select placeholder="请选择类型(出库/入库)" v-model="queryParam.type" style="width: 100%" allow-clear>
                  <a-select-option v-for="(d, index) in typeOptions" :key="index" :value="d.dictValue">{{ d.dictLabel }}</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="出入库分类" prop="subType">
                <a-select placeholder="请选择出入库分类" v-model="queryParam.subType" style="width: 100%" allow-clear>
                  <a-select-option v-for="(d, index) in subTypeOptions" :key="index" :value="d.dictValue">{{ d.dictLabel }}</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
<!--            <template v-if="advanced">-->
<!--              <a-col :md="8" :sm="24">-->
<!--                <a-form-item label="供应商id" prop="organId">-->
<!--                  <a-select v-model="queryParam.organId" placeholder="请输入供应商id">-->
<!--                    <a-select-option v-for="(supplier ,index) in supplierList" :key="index" :value="supplier.supplierId">-->
<!--                      {{ supplier.supplierName }}-->
<!--                    </a-select-option>-->
<!--                  </a-select>-->
<!--                </a-form-item>-->
<!--              </a-col>-->
<!--              <a-col :md="8" :sm="24">-->
<!--                <a-form-item label="采购/领料-经手人id" prop="agentId">-->
<!--                  <a-select v-model="queryParam.agentId" placeholder="请输入采购/领料-经手人id">-->
<!--                    <a-select-option v-for="(agent ,index) in agentList" :key="index" :value="agent.agentId">-->
<!--                      {{agent.agentName}}-->
<!--                    </a-select-option>-->
<!--                  </a-select>-->
<!--                </a-form-item>-->
<!--              </a-col>-->
<!--            </template>-->
            <a-col :md="!advanced && 8 || 24" :sm="24">
              <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
                <a-button type="primary" @click="handleQuery"><a-icon type="search" />查询</a-button>
                <a-button style="margin-left: 8px" @click="resetQuery"><a-icon type="redo" />重置</a-button>
<!--                <a @click="toggleAdvanced" style="margin-left: 8px">-->
<!--                  {{ advanced ? '收起' : '展开' }}-->
<!--                  <a-icon :type="advanced ? 'up' : 'down'"/>-->
<!--                </a>-->
              </span>
            </a-col>
          </a-row>
        </a-form>
      </div>
      <!-- 操作 -->
      <div class="table-operations">
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['purchase:purchaseout:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['purchase:purchaseout:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['purchase:purchaseout:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['purchase:purchaseout:export']">
          <a-icon type="download" />导出
        </a-button>
        <a-button
          type="dashed"
          shape="circle"
          :loading="loading"
          :style="{float: 'right'}"
          icon="reload"
          @click="getList" />
      </div>
      <!-- 增加修改 -->
      <create-form
        ref="createForm"
        :typeOptions="typeOptions"
        :subTypeOptions="subTypeOptions"
        :payTypeOptions="payTypeOptions"
        :statusOptions="statusOptions"
        @ok="getList"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="jxcHeadId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="type" slot-scope="text, record">
          {{ typeFormat(record) }}
        </span>
        <span slot="subType" slot-scope="text, record">
          {{ subTypeFormat(record) }}
        </span>
        <span slot="operTime" slot-scope="text, record">
          {{ parseTime(record.operTime) }}
        </span>
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['purchase:purchaseout:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['purchase:purchaseout:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['purchase:purchaseout:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['purchase:purchaseout:remove']">
            <a-icon type="delete" />删除
          </a>
        </span>
        <span slot="number" slot-scope="text">
           {{'CGCK'+text}}
        </span>
        <template slot="status" slot-scope="status">
          <a-tag v-if="status === '0'" color="red">未审核</a-tag>
          <a-tag v-if="status === '1'" color="green">已审核</a-tag>
          <a-tag v-if="status === '2'" color="blue">已转采购</a-tag>
          <a-tag v-if="status === '3'" color="yellow">已转销售</a-tag>
        </template>
      </a-table>
      <!-- 分页 -->
      <a-pagination
        class="ant-table-pagination"
        show-size-changer
        show-quick-jumper
        :current="queryParam.pageNum"
        :total="total"
        :page-size="queryParam.pageSize"
        :showTotal="total => `共 ${total} 条`"
        @showSizeChange="onShowSizeChange"
        @change="changeSize"
      />
    </a-card>
  </page-header-wrapper>
</template>

<script>
import { listPurchaseout, delPurchaseout, exportPurchaseout } from '@/api/purchase/purchaseout'
import { listSupplier } from '@/api/base/supplier'
import { listAgent } from '@/api/base/agent'
import { listUser } from '@/api/system/user'
import CreateForm from './modules/CreateForm'

export default {
  name: 'Purchaseout',
  components: {
    CreateForm
  },
  data () {
    return {
      list: [],
      // 操作员数据
      userList: null,
      selectedRowKeys: [],
      selectedRows: [],
      // 订单状态的字典
      statusOptions: [],
      // 经手人数据
      agentList: null,
      // 供应商数据
      supplierList: null,
      // 高级搜索 展开/关闭
      advanced: false,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      ids: [],
      loading: false,
      total: 0,
      // 类型(出库/入库)字典
      typeOptions: [],
      // 出入库分类字典
      subTypeOptions: [],
      // 付款(现金/记账)字典
      payTypeOptions: [],
      // 查询参数
      query: {
        supplierId: null,
        supplierName: null,
        type: '0'
      },
      query2: {
        agentId: null,
        agentType: '0',
        agentName: null
      },
      query3: {
        userId: null,
        nickName: null
      },
      queryParam: {
        type: null,
        subType: null,
        organId: null,
        agentId: null,
        pageNum: 1,
        pageSize: 10
      },
      columns: [
        // {
        //   title: '主键',
        //   dataIndex: 'jxcHeadId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '类型(出库/入库)',
        //   dataIndex: 'type',
        //   scopedSlots: { customRender: 'type' },
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '出入库分类',
        //   dataIndex: 'subType',
        //   scopedSlots: { customRender: 'subType' },
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '初始票据号',
        //   dataIndex: 'defaultNumber',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '供应商名称',
          dataIndex: 'organId',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '票据号',
          dataIndex: 'number',
          ellipsis: true,
          scopedSlots: { customRender: 'number' },
          align: 'center'
        },
        {
          title: '商品信息',
          dataIndex: '待编写获取子表商品规格信息',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '出入库时间',
          dataIndex: 'operTime',
          scopedSlots: { customRender: 'operTime' },
          ellipsis: true,
          align: 'center'
        },

        // {
        //   title: '采购/领料-经手人id',
        //   dataIndex: 'agentId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '操作员',
          dataIndex: 'creator',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '账户id',
        //   dataIndex: 'accountId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '变动金额(收款/付款)',
        //   dataIndex: 'changeAmount',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '合计金额',
          dataIndex: 'totalPrice',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '付款类型(现金、记账等)',
        //   dataIndex: 'payType',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '单据类型',
        //   dataIndex: 'billType',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '备注',
        //   dataIndex: 'remark',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '附件名称',
        //   dataIndex: 'fileName',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '业务员',
        //   dataIndex: 'salesMan',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '多账户ID列表',
        //   dataIndex: 'accountIdList',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '多账户金额列表',
        //   dataIndex: 'accountMoneyList',
        //   ellipsis: true,
        //   align: 'center'
        // // },
        // {
        //   title: '优惠率',
        //   dataIndex: 'discount',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '优惠金额',
        //   dataIndex: 'discountMoney',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '优惠后金额',
          dataIndex: 'discountLastMoney',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '销售或采购费用合计',
        //   dataIndex: 'otherMoney',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '销售或采购费用涉及项目Id数组',
        //   dataIndex: 'otherMoneyList',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '销售或采购费用涉及项目',
        //   dataIndex: 'otherMoneyItem',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '结算天数',
        //   dataIndex: 'accountDay',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '状态',
          dataIndex: 'status',
          scopedSlots: { customRender: 'status' },
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '关联订单号',
        //   dataIndex: 'linkNumber',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '租户id',
        //   dataIndex: 'tenantId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '删除标记，0未删除，1删除',
        //   dataIndex: 'deleteFlag',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '操作',
          dataIndex: 'operation',
          width: '18%',
          scopedSlots: { customRender: 'operation' },
          align: 'center'
        }
      ]
    }
  },
  filters: {
  },
  created () {
    this.getList()
    this.getDicts('erp_deposit_iotype').then(response => {
      this.typeOptions = response.data
    })
    this.getDicts('erp_deposit_sub_iotype').then(response => {
      this.subTypeOptions = response.data
    })
    this.getDicts('erp_pay_type').then(response => {
      this.payTypeOptions = response.data
    })
    this.getDicts('erp_order_status').then(response => {
      this.statusOptions = response.data
    })
    listSupplier(this.query).then(response => {
      this.supplierList = response.rows
    })
    listAgent(this.query2).then(response => {
      this.agentList = response.rows
    })
  },
  computed: {
  },
  watch: {
  },
  methods: {
    /** 查询采购出库列表 */
    getList () {
      this.loading = true
      listPurchaseout(this.queryParam).then(response => {
        this.list = response.rows.filter(function (n) {
          return n.status === '2'
        })
        this.total = response.total
        this.loading = false
        // 将list的数据中的供应商改掉
        listSupplier(this.query).then(response => {
          this.supplierList = response.rows
          for (let i = 0; i < this.list.length; i++) {
            for (let j = 0; j < this.supplierList.length; j++) {
              if (this.list[i].organId === this.supplierList[j].supplierId) {
                this.list[i].organId = this.supplierList[j].supplierName
              }
            }
          }
        })
        // 将操作人员改掉
        listUser(this.query3).then(response => {
          this.userList = response.rows
          for (let i = 0; i < this.list.length; i++) {
            for (let j = 0; j < this.userList.length; j++) {
              if (this.list[i].creator === this.userList[j].userId) {
                this.list[i].creator = this.userList[j].nickName
              }
            }
          }
        })
      })
    },
    // 类型(出库/入库)字典翻译
    typeFormat (row, column) {
      return this.selectDictLabel(this.typeOptions, row.type)
    },
    // 出入库分类字典翻译
    subTypeFormat (row, column) {
      return this.selectDictLabel(this.subTypeOptions, row.subType)
    },
    // 付款类型字典翻译
    payTypeFormat (row, column) {
      return this.selectDictLabel(this.payTypeOptions, row.payType)
    },
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParam.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.queryParam = {
        type: undefined,
        subType: undefined,
        organId: undefined,
        agentId: undefined,
        pageNum: 1,
        pageSize: 10
      }
      this.handleQuery()
    },
    onShowSizeChange (current, pageSize) {
      this.queryParam.pageSize = pageSize
      this.getList()
    },
    changeSize (current, pageSize) {
      this.queryParam.pageNum = current
      this.queryParam.pageSize = pageSize
      this.getList()
    },
    onSelectChange (selectedRowKeys, selectedRows) {
      this.selectedRowKeys = selectedRowKeys
      this.selectedRows = selectedRows
      this.ids = this.selectedRows.map(item => item.jxcHeadId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const jxcHeadIds = row.jxcHeadId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + jxcHeadIds + '的数据',
        onOk () {
          return delPurchaseout(jxcHeadIds)
            .then(() => {
              that.onSelectChange([], [])
              that.getList()
              that.$message.success(
                '删除成功',
                3
              )
          })
        },
        onCancel () {}
      })
    },
    /** 导出按钮操作 */
    handleExport () {
      var that = this
      this.$confirm({
        title: '是否确认导出?',
        content: '此操作将导出当前条件下所有数据而非选中数据',
        onOk () {
          return exportPurchaseout(that.queryParam)
            .then(response => {
              that.download(response.msg)
              that.$message.success(
                '导出成功',
                3
              )
          })
        },
        onCancel () {}
      })
    }
  }
}
</script>
