<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="类型名称" prop="typeName">
                <a-input v-model="queryParam.typeName" placeholder="请输入类型名称" allow-clear/>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="编号" prop="serialNo">
                <a-input v-model="queryParam.serialNo" placeholder="请输入编号" allow-clear/>
              </a-form-item>
            </a-col>
            <a-col :md="!advanced && 8 || 24" :sm="24">
              <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
                <a-button type="primary" @click="handleQuery"><a-icon type="search" />查询</a-button>
                <a-button style="margin-left: 8px" @click="resetQuery"><a-icon type="redo" />重置</a-button>
              </span>
            </a-col>
          </a-row>
        </a-form>
      </div>
      <!-- 操作 -->
      <div class="table-operations">
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['material:materialtype:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['material:materialtype:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['material:materialtype:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['material:materialtype:export']">
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
        :materialtypeOptions="materialtypeOptions"
        @select-tree="getTreeselect"
        @ok="getList"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="materialTypeId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['material:materialtype:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['material:materialtype:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['material:materialtype:add']" />
          <a @click="$refs.createForm.handleAdd(record)" v-hasPermi="['material:materialtype:add']">
            <a-icon type="plus" />新增
          </a>
          <a-divider type="vertical" v-hasPermi="['material:materialtype:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['material:materialtype:remove']">
            <a-icon type="delete" />删除
          </a>
        </span>
      </a-table>
    </a-card>
  </page-header-wrapper>
</template>

<script>
import { listMaterialtype, delMaterialtype, exportMaterialtype } from '@/api/material/materialtype'
import CreateForm from './modules/CreateForm'

export default {
  name: 'Materialtype',
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
      materialtypeOptions: [],
      // 查询参数
      queryParam: {
        typeName: null,
        serialNo: null,
        pageNum: 1,
        pageSize: 10
      },
      columns: [
        {
          title: '类型id',
          dataIndex: 'materialTypeId',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '父类型id',
          dataIndex: 'parentId',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '祖级列表',
        //   dataIndex: 'ancestors',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '类型名称',
          dataIndex: 'typeName',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '编号',
          dataIndex: 'serialNo',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '备注',
        //   dataIndex: 'remark',
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
  },
  computed: {
  },
  watch: {
  },
  methods: {
    /** 查询商品类型列表 */
    getList () {
      this.loading = true
      listMaterialtype(this.queryParam).then(response => {
        this.list = this.handleTree(response.data, 'materialTypeId', 'parentId')
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
        typeName: undefined,
        serialNo: undefined,
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
      this.ids = this.selectedRows.map(item => item.materialTypeId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 查询菜单下拉树结构 */
    getTreeselect () {
      listMaterialtype().then(response => {
        this.materialtypeOptions = []
        const data = { materialTypeId: 0, typeName: '主目录', children: [] }
        data.children = this.handleTree(response.data, 'materialTypeId', 'parentId')
        this.materialtypeOptions.push(data)
      })
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const materialTypeIds = row.materialTypeId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + materialTypeIds + '的数据',
        onOk () {
          return delMaterialtype(materialTypeIds)
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
          return exportMaterialtype(that.queryParam)
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
