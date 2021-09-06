<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="父类型id" prop="parentId" >
        <a-tree-select
          v-model="form.parentId"
          style="width: 100%"
          :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
          :tree-data="materialtypeOptions"
          placeholder="请选择"
          :replaceFields="{children:'children', title:'typeName', key:'materialTypeId', value: 'materialTypeId' }"
          tree-default-expand-all
        >
        </a-tree-select>
      </a-form-model-item>
      <a-form-model-item label="类型名称" prop="typeName" >
        <a-input v-model="form.typeName" placeholder="请输入类型名称" />
      </a-form-model-item>
      <a-form-model-item label="显示顺序" prop="orderNum" >
        <a-input v-model="form.orderNum" placeholder="请输入显示顺序" />
      </a-form-model-item>
      <a-form-model-item label="编号" prop="serialNo" >
        <a-input v-model="form.serialNo" placeholder="请输入编号" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户id" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户id" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标记" prop="deleteFlag" >
        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />
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
import { getMaterialtype, addMaterialtype, updateMaterialtype } from '@/api/material/materialtype'

export default {
  name: 'CreateForm',
  props: {
    materialtypeOptions: {
      type: Array,
      required: true
    }
  },
  components: {
  },
  data () {
    return {
      loading: false,
      formTitle: '',
      // 表单参数
      form: {
        materialTypeId: null,
        parentId: null,
        ancestors: null,
        typeName: null,
        orderNum: null,
        serialNo: null,
        remark: null,
        createTime: null,
        updateTime: null,
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
    },
    // 取消按钮
    cancel () {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset () {
      this.formType = 1
      this.form = {
        materialTypeId: null,
        parentId: null,
        ancestors: null,
        typeName: null,
        orderNum: null,
        serialNo: null,
        remark: null,
        createTime: null,
        updateTime: null,
        tenantId: null,
        deleteFlag: null
      }
    },
    /** 新增按钮操作 */
    handleAdd (row) {
      this.reset()
      this.$emit('select-tree')
      if (row != null && row.materialTypeId) {
        this.form.parentId = row.materialTypeId
      } else {
        this.form.parentId = 0
      }
      this.formType = 1
      this.open = true
      this.formTitle = '添加'
    },
    /** 修改按钮操作 */
    handleUpdate (row, ids) {
      this.reset()
      this.$emit('select-tree')
      this.formType = 2
      const materialTypeId = row ? row.materialTypeId : ids
      getMaterialtype(materialTypeId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.materialTypeId !== undefined && this.form.materialTypeId !== null) {
            updateMaterialtype(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addMaterialtype(this.form).then(response => {
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
