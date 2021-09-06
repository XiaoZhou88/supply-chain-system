<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <!-- 条件搜索 -->
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="商品类型名" prop="materialtypeId">
                <a-tree-select
                  v-model="queryParam.materialtypeId"
                  style="width: 100%"
                  :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                  :tree-data="materialtypeOptions"
                  placeholder="请选择"
                  :replaceFields="{children:'children', title:'typeName', key:'materialTypeId', value: 'materialTypeId' }"
                  tree-default-expand-all
                >
                </a-tree-select>
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="商品名称" prop="materialName">
                <a-input v-model="queryParam.materialName" placeholder="请输入名称" allow-clear/>
              </a-form-item>
            </a-col>
            <template v-if="advanced">
              <a-col :md="8" :sm="24">
                <a-form-item label="制造商" prop="mfrs">
                  <a-input v-model="queryParam.mfrs" placeholder="请输入制造商" allow-clear/>
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
        <a-button type="primary" @click="$refs.createForm.handleAdd()" v-hasPermi="['material:materialinfo:add']">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="primary" :disabled="single" @click="$refs.createForm.handleUpdate(undefined, ids)" v-hasPermi="['material:materialinfo:edit']">
          <a-icon type="edit" />修改
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete" v-hasPermi="['material:materialinfo:remove']">
          <a-icon type="delete" />删除
        </a-button>
        <a-button type="primary" @click="handleExport" v-hasPermi="['material:materialinfo:export']">
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
        :statusOptions="statusOptions"
        @ok="getList"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="materialId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <template slot="customRenderEnabled" slot-scope="enabled">
          <a-tag v-if="enabled" color="green">启用</a-tag>
          <a-tag v-if="!enabled" color="orange">禁用</a-tag>
        </template>
        <span slot="exmasterial">
          <sub-table ref="subTable" :list="sublist2" />
      <a-button type="dashed" @click="$refs.subTable.show()">
        详情
      </a-button>
        </span>
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" v-hasPermi="['material:materialinfo:edit']" />
          <a @click="$refs.createForm.handleUpdate(record, undefined)" v-hasPermi="['material:materialinfo:edit']">
            <a-icon type="edit" />修改
          </a>
          <a-divider type="vertical" v-hasPermi="['material:materialinfo:remove']" />
          <a @click="handleDelete(record)" v-hasPermi="['material:materialinfo:remove']">
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
import { listMaterialinfo, delMaterialinfo, exportMaterialinfo } from '@/api/material/materialinfo'
import { listMaterialtype } from '@/api/material/materialtype'
import CreateForm from './modules/CreateForm'
import SubTable from './modules/SubTable'
export default {
  name: 'Materialinfo',
  components: {
    CreateForm,
    SubTable
  },
  data () {
    return {
      // 表单数据
      sublist2: [],
      list: [],
      selectedRowKeys: [],
      selectedRows: [],
      // 商品类型树选项
      materialtypeOptions: [],
      // 状态字典
      statusOptions: [],
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
      query: {
        barCode: null,
        commodityUnit: null,
        purchaseDecimal: null,
        commodityDecimal: null,
        wholesaleDecimal: null,
        lowDecimal: null
      },
      queryParam: {
        materialtypeId: null,
        materialName: null,
        mfrs: null,
        pageNum: 1,
        pageSize: 10
      },
      columns: [
        // {
        //   title: '商品类型id',
        //   dataIndex: 'materialtypeId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '商品类型名',
          dataIndex: 'materialType.typeName',
          ellipsis: true,
          align: 'center',
          width: 100
        },
        {
          title: '商品名称',
          dataIndex: 'materialName',
          ellipsis: true,
          align: 'center',
          width: 100
        },
        {
          title: '制造商',
          dataIndex: 'mfrs',
          ellipsis: true,
          align: 'center',
          width: 80
        },
        {
          title: '规格',
          dataIndex: 'standard',
          ellipsis: true,
          align: 'center',
          width: 80
        },
        {
          title: '型号',
          dataIndex: 'model',
          ellipsis: true,
          align: 'center',
          width: 80
        },
        {
          title: '颜色',
          dataIndex: 'color',
          ellipsis: true,
          align: 'center',
          width: 50
        },
        // {
        //   title: '扩展信息',
        //   dataIndex: 'exmasterial',
        //   ellipsis: true,
        //   align: 'center',
        //   scopedSlots: { customRender: 'exmasterial' },
        //   width: 80
        // },
        {
          title: '单位',
          dataIndex: 'unit',
          ellipsis: true,
          align: 'center',
          width: 50
        },
        {
          title: '安全存量',
          dataIndex: 'safetyStock',
          ellipsis: true,
          align: 'center',
          width: 80
        },
        // {
        //   title: '库存',
        //   dataIndex: 'stock',
        //   ellipsis: true,
        //   align: 'center',
        //   width: 70
        // },
        // {
        //   title: '备注',
        //   dataIndex: 'remark',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '状态',
          dataIndex: 'enabled',
          width: 60,
          align: 'center',
          ellipsis: true,
          scopedSlots: { customRender: 'customRenderEnabled' }
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
    this.getTreeselect()
    this.getDicts('erp_isEnable').then(response => {
          this.statusOptions = response.data
    })
  },
  computed: {
  },
  watch: {
  },
  methods: {
    /** 查询商品信息列表 */
    getList () {
      this.loading = true
      listMaterialinfo(this.queryParam).then(response => {
        this.list = response.rows
        this.total = response.total
        this.loading = false
      })
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
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParam.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.queryParam = {
        materialtypeId: undefined,
        materialName: undefined,
        mfrs: undefined,
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
      this.ids = this.selectedRows.map(item => item.materialId)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    toggleAdvanced () {
      this.advanced = !this.advanced
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      const materialIds = row.materialId || this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中编号为' + materialIds + '的数据',
        onOk () {
          return delMaterialinfo(materialIds)
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
          return exportMaterialinfo(that.queryParam)
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
