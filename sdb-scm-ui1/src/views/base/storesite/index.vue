<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="库位编码" prop="storesiteCode">
                <a-input v-model="queryParam.storesiteCode" placeholder="请输入库位编码" allow-clear/>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="库位名称" prop="storesiteName">
                <a-input v-model="queryParam.storesiteName" placeholder="请输入库位名称" allow-clear/>
              </a-form-item>
            </a-col>
            <template v-if="advanced">
              <a-col :md="8" :sm="24">
                <a-form-item label="所属库区" prop="regionId">
                  <a-select placeholder="所属库区" v-model="queryParam.regionId">
                    <a-select-option v-for="(d, index) in regionList" :key="index" :value="d.depositRegionId" >{{ d.regionName }}</a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="库位类型" prop="storeType">
                  <a-select placeholder="请选择库位类型(数据字典：收货、发货、存储、暂存、良品、不良等)" v-model="queryParam.storeType" style="width: 100%" allow-clear>
                    <a-select-option v-for="(d, index) in storeTypeOptions" :key="index" :value="d.dictValue">{{ d.dictLabel }}</a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="库位属性" prop="storeAttribute">
                  <a-select placeholder="请选择库位属性(数据字典：冷藏、恒温、常温等)" v-model="queryParam.storeAttribute" style="width: 100%" allow-clear>
                    <a-select-option v-for="(d, index) in storeAttributeOptions" :key="index" :value="d.dictValue">{{ d.dictLabel }}</a-select-option>
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
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['base:storesite:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['base:storesite:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['base:storesite:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['base:storesite:export']">
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
        :storeTypeOptions="storeTypeOptions"
        :storeAttributeOptions="storeAttributeOptions"
        @ok="getList"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="depositStoresiteId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="storeType" slot-scope="text, record">
          {{ storeTypeFormat(record) }}
        </span>
        <span slot="storeAttribute" slot-scope="text, record">
          {{ storeAttributeFormat(record) }}
        </span>
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['base:storesite:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['base:storesite:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['base:storesite:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['base:storesite:remove']">
            <a-icon type="delete" />删除
          </a>
        </span>
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
import { listStoresite, delStoresite, exportStoresite } from '@/api/base/storesite'
import { listRegion } from '@/api/base/storeregion'
import CreateForm from './modules/CreateForm'
export default {
  name: 'Storesite',
  components: {
    CreateForm
  },
  data () {
    return {
      list: [],
      selectedRowKeys: [],
      selectedRows: [],
      regionList: null,
      query: {
        depositRegionId: null,
        regionName: null
      },
      // 高级搜索 展开/关闭
      advanced: false,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      ids: [],
      loading: false,
      total: 0,
      // 库位类型(数据字典：收货、发货、存储、暂存、良品、不良等)字典
      storeTypeOptions: [],
      // 库位属性(数据字典：冷藏、恒温、常温等)字典
      storeAttributeOptions: [],
      // 查询参数
      queryParam: {
        storesiteCode: null,
        storesiteName: null,
        regionId: null,
        storeType: null,
        storeAttribute: null,
        pageNum: 1,
        pageSize: 10
      },
      columns: [
        {
          title: '库位编码',
          dataIndex: 'storesiteCode',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位名称',
          dataIndex: 'storesiteName',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '所属库区',
          dataIndex: 'regionId',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位类型',
          dataIndex: 'storeType',
          scopedSlots: { customRender: 'storeType' },
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位属性',
          dataIndex: 'storeAttribute',
          scopedSlots: { customRender: 'storeAttribute' },
          ellipsis: true,
          align: 'center'
        },
        {
          title: '出库口',
          dataIndex: 'outbound',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '空库位标识',
          dataIndex: 'isEmpty',
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
    this.getDicts('erp_deposit_store_type').then(response => {
      this.storeTypeOptions = response.data
    })
    this.getDicts('erp_deposit_store_property').then(response => {
      this.storeAttributeOptions = response.data
    })
    listRegion(this.query).then(response => {
      this.regionList = response.rows
    })
  },
  computed: {
  },
  watch: {
  },
  methods: {
    /** 查询库位设置列表 */
    getList () {
      this.loading = true
      listStoresite(this.queryParam).then(response => {
        this.list = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 库位类型(数据字典：收货、发货、存储、暂存、良品、不良等)字典翻译
    storeTypeFormat (row, column) {
      return this.selectDictLabel(this.storeTypeOptions, row.storeType)
    },
    // 库位属性(数据字典：冷藏、恒温、常温等)字典翻译
    storeAttributeFormat (row, column) {
      return this.selectDictLabel(this.storeAttributeOptions, row.storeAttribute)
    },
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParam.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.queryParam = {
        storesiteCode: undefined,
        storesiteName: undefined,
        regionId: undefined,
        storeType: undefined,
        storeAttribute: undefined,
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
      this.ids = this.selectedRows.map(item => item.depositStoresiteId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const depositStoresiteIds = row.depositStoresiteId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + depositStoresiteIds + '的数据',
        onOk () {
          return delStoresite(depositStoresiteIds)
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
          return exportStoresite(that.queryParam)
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
