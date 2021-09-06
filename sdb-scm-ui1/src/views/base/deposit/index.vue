<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="仓库名称" prop="depositName">
                <a-input v-model="queryParam.depositName" placeholder="请输入仓库名称" allow-clear/>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="仓库地址" prop="address">
                <a-input v-model="queryParam.address" placeholder="请输入仓库地址" allow-clear/>
              </a-form-item>
            </a-col>
            <template v-if="advanced">
              <a-col :md="8" :sm="24">
                <a-form-item label="负责人" prop="principal">
                  <a-select v-model="queryParam.principal" style="width: 120px">
                    <a-select-option v-for="(user, index ) in userList" :key="index" :value="user.userId">
                      {{ user.userName }}
                    </a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
            </template>
            <a-col :md="!advanced && 8 || 24" :sm="24">
              <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
                <a-button type="primary" @click="handleQuery"><a-icon type="search" />查询</a-button>
                <a-button style="margin-left: 8px" @click="resetQuery"><a-icon type="redo" />重置</a-button>
                <a @click="toggleAdvanced" style="margin-left: 8px">
                  {{ advanced ? '收起' : '展开' }}
                  <a-icon :type="advanced ? 'up' : 'down'"/>
                </a>
              </span>
            </a-col>
          </a-row>
        </a-form>
      </div>
      <!-- 操作 -->
      <div class="table-operations">
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['base:deposit:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['base:deposit:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['base:deposit:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['base:deposit:export']">
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
        @ok="getList"

      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="depositId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="type" slot-scope="text,record">{{typeFormat(record)}}</span>
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['base:deposit:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['base:deposit:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['base:deposit:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['base:deposit:remove']">
            <a-icon type="delete" />删除
          </a>
        </span>
<!--        <span slot="dispuserNameByuserId" slot-scope="text, record">-->
<!--            {{ getUserName(record.principal) }}-->
<!--        </span>-->
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
import { listDeposit, delDeposit, exportDeposit } from '@/api/base/deposit'
import CreateForm from './modules/CreateForm'
// import { getUser } from '@/api/system/user'
import { listUser } from '@/api/system/user'
export default {
  name: 'Deposit',
  components: {
    CreateForm
  },
  data () {
    return {
      list: [],
      userList: null,
      selectedRowKeys: [],
      selectedRows: [],
      // 收支类型字典
      typeOptions: [],
      // 高级搜索 展开/关闭
      advanced: false,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      ids: [],
      loading: false,
      total: 0,
      // userName: null,
      // 查询参数
      queryParam: {
        depositName: null,
        address: null,
        principal: null,
        pageNum: 1,
        pageSize: 10
      },
      query: {
        userName: null,
        deptId: null,
        userId: null
      },
      columns: [
        {
          title: '仓库名称',
          dataIndex: 'depositName',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '仓库地址',
          dataIndex: 'address',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '仓储费',
          dataIndex: 'warehousing',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '搬运费',
          dataIndex: 'truckage',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '类型',
          dataIndex: 'type',
          ellipsis: true,
          scopedSlots: { customRender: 'type' },
          align: 'center'
        },
        // {
        //   title: '负责人',
        //   dataIndex: 'principal',
        //   scopedSlots: { customRender: 'dispuserNameByuserId'},
        //   align: 'center'
        // },
        {
          title: '负责人姓名',
          dataIndex: 'user.userName',
          ellipsis: true,
          align: 'center'
        },
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
    this.getDicts('erp_deposit_type').then(response => {
      this.typeOptions = response.data
    })
      listUser(this.query).then(response => {
        this.userList = response.rows
        // for (let item of this.userList) {
        //   console.log(item + '---' + this.userList[item].userId + '---' + this.userList[item].userName)
        // }
      })
  },
  computed: {
  },
  watch: {
  },
  methods: {
    // getUserName (user) {
    //   getUser(user).then(response => {
    //     this.userName =  response.data.userName
    //   })
    //   return this.userName
    // },
    /** 查询仓库列表 */
    getList () {
      this.loading = true
      listDeposit(this.queryParam).then(response => {
        this.list = response.rows
        // console.log( this.list )
        // this.list.forEach(this.iterArray)
        this.total = response.total
        this.loading = false
      })
    },
    typeFormat (row, column) {
      return this.selectDictLabel(this.typeOptions, row.type)
    },
    // iterArray( value, index, array) {
    //   console.log('index is --'+ index)
    //   console.log('value is ---'+ value)
    //   for ( let item in value ){
    //     console.log(value[item])
    //   }
    // },
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParam.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.queryParam = {
        depositName: undefined,
        address: undefined,
        principal: undefined,
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
      this.ids = this.selectedRows.map(item => item.depositId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const depositIds = row.depositId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + depositIds + '的数据',
        onOk () {
          return delDeposit(depositIds)
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
          return exportDeposit(that.queryParam)
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
