<template>
  <a-modal
    ref="subTableModel"
    :title="'进销存单据子'"
    width="80%"
    :visible="visible"
    @cancel="close"
  >
    <template slot="footer">
      <a-button type="dashed" @click="close">
        关闭
      </a-button>
    </template>
    <a-card :bordered="false">
      <!-- 操作 -->
      <div class="table-operations">
        <a-button type="primary" @click="$refs.createSubForm.handleAdd()">
          <a-icon type="plus" />新增
        </a-button>
        <a-button type="danger" :disabled="multiple" @click="handleDelete">
          <a-icon type="delete" />删除
        </a-button>
      </div>
      <!-- 增加修改 -->
      <create-sub-form
        ref="createSubForm"
        @add="handleAddErpJxcItem"
      />
      <!-- 数据展示 -->
      <a-table
        :loading="loading"
        :size="tableSize"
        rowKey="headerId"
        :columns="columns"
        :data-source="list"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        :pagination="false">
        <span slot="operation" slot-scope="text, record">
          <a-divider type="vertical" />
          <a @click="handleDelete(record)">
            <a-icon type="delete" />删除
          </a>
        </span>
      </a-table>
    </a-card>
  </a-modal>
</template>

<script>
import CreateSubForm from './CreateSubForm'

export default {
  name: 'SubTable',
  components: {
    CreateSubForm
  },
  props: {
    list: {
      type: Array,
      required: true
    }
  },
  data () {
    return {
      visible: false,
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
      columns: [
        {
          title: '商品Id',
          dataIndex: 'materialId',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '商品扩展id',
        //   dataIndex: 'materialExtendId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '商品计量单位',
        //   dataIndex: 'materialUnit',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '数量',
          dataIndex: 'operNumber',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '基础数量，如kg、瓶',
        //   dataIndex: 'basicNumber',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '含税单价',
          dataIndex: 'taxUnitPrice',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '金额',
          dataIndex: 'allPrice',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '备注',
          dataIndex: 'remark',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '图片',
        //   dataIndex: 'img',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '运杂费',
        //   dataIndex: 'incidentals',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '仓库ID',
          dataIndex: 'depotId',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '调拨时，对方仓库Id',
        //   dataIndex: 'anotherDepotId',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '税率',
          dataIndex: 'taxRate',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '税额',
          dataIndex: 'taxMoney',
          ellipsis: true,
          align: 'center'
        },
        {
          title: '价税合计',
          dataIndex: 'taxLastMoney',
          ellipsis: true,
          align: 'center'
        },
        // {
        //   title: '自定义字段1-名称',
        //   dataIndex: 'otherField1',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '自定义字段2-型号',
        //   dataIndex: 'otherField2',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '自定义字段3-制造商',
        //   dataIndex: 'otherField3',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '自定义字段4-名称',
        //   dataIndex: 'otherField4',
        //   ellipsis: true,
        //   align: 'center'
        // },
        // {
        //   title: '自定义字段5-名称',
        //   dataIndex: 'otherField5',
        //   ellipsis: true,
        //   align: 'center'
        // },
        {
          title: '商品类型',
          dataIndex: 'materialType',
          ellipsis: true,
          align: 'center'
        },
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
  },
  computed: {
  },
  watch: {
  },
  methods: {
    // 关闭模态框
    close () {
      this.visible = false
      this.selectedRowKeys = []
      this.selectedRows = []
    },
    // 打开抽屉(由外面的组件调用)
    show () {
      this.visible = true
    },
    onSelectChange (selectedRowKeys, selectedRows) {
      this.selectedRowKeys = selectedRowKeys
      this.selectedRows = selectedRows
      this.ids = selectedRowKeys.map(item => item - 1)
      this.single = selectedRowKeys.length !== 1
      this.multiple = !selectedRowKeys.length
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      var that = this
      if (row) {
        var index = (this.list || []).findIndex((item) => item === row)
      }
      const ids = index !== undefined ? index : this.ids
      this.$confirm({
        title: '确认删除所选中数据?',
        content: '当前选中序号为' + ids + '的数据',
        onOk () {
          that.$emit('delete', index, ids)
        },
        onCancel () {}
      })
    },
    handleAddErpJxcItem (row) {
      this.$emit('add', row)
    }
  }
}
</script>
