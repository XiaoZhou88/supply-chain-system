<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="名称" prop="storesizeName">
                <a-input v-model="queryParam.storesizeName" placeholder="请输入库位尺寸名称" allow-clear/>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="库位长度" prop="length">
                <a-input v-model="queryParam.length" placeholder="请输入库位长度(单位:毫米)" allow-clear/>
              </a-form-item>
            </a-col>
            <template v-if="advanced">
              <a-col :md="8" :sm="24">
                <a-form-item label="库位宽度" prop="width">
                  <a-input v-model="queryParam.width" placeholder="请输入库位宽度(单位:毫米)" allow-clear/>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="库位高度" prop="height">
                  <a-input v-model="queryParam.height" placeholder="请输入库位高度(单位:毫米)" allow-clear/>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="最大重量" prop="maxWeight">
                  <a-input v-model="queryParam.maxWeight" placeholder="请输入最大重量(单位:千克)" allow-clear/>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="最大托盘" prop="maxTray">
                  <a-input v-model="queryParam.maxTray" placeholder="请输入最大托盘(单位:件)" allow-clear/>
                </a-form-item>
              </a-col>
              <a-col :md="8" :sm="24">
                <a-form-item label="最大体积" prop="maxVolume">
                  <a-input v-model="queryParam.maxVolume" placeholder="请输入最大体积(单位:立方毫米)" allow-clear/>
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
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['base:storesize:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['base:storesize:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['base:storesize:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['base:storesize:export']">
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
        @ok="getList"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="storesizeId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['base:storesize:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['base:storesize:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['base:storesize:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['base:storesize:remove']">
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
import { listStoresize, delStoresize, exportStoresize } from '@/api/base/storesize'
import CreateForm from './modules/CreateForm'

export default {
  name: 'Storesize',
  components: {
    CreateForm
  },
  data () {
    return {
      list: [],
      selectedRowKeys: [],
      selectedRows: [],
      // 高级搜索 展开/关闭
      advanced: false,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      ids: [],
      loading: false,
      total: 0,
      // 查询参数
      queryParam: {
        storesizeName: null,
        length: null,
        width: null,
        height: null,
        maxWeight: null,
        maxTray: null,
        maxVolume: null,
        pageNum: 1,
        pageSize: 10
      },
      columns: [
        {
          title: '尺寸名称',
          dataIndex: 'storesizeName',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位长度',
          dataIndex: 'length',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位宽度',
          dataIndex: 'width',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '库位高度',
          dataIndex: 'height',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '最大重量',
          dataIndex: 'maxWeight',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '最大托盘',
          dataIndex: 'maxTray',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '最大体积',
          dataIndex: 'maxVolume',
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
  },
  computed: {
  },
  watch: {
  },
  methods: {
    /** 查询库位尺寸列表 */
    getList () {
      this.loading = true
      listStoresize(this.queryParam).then(response => {
        this.list = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParam.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.queryParam = {
        storesizeName: undefined,
        length: undefined,
        width: undefined,
        height: undefined,
        maxWeight: undefined,
        maxTray: undefined,
        maxVolume: undefined,
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
      this.ids = this.selectedRows.map(item => item.storesizeId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const storesizeIds = row.storesizeId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + storesizeIds + '的数据',
        onOk () {
          return delStoresize(storesizeIds)
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
          return exportStoresize(that.queryParam)
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
