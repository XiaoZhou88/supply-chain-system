<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="商品类型名称" prop="materialtypeId" >
        <a-tree-select
          v-model="form.materialtypeId"
          style="width: 100%"
          :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
          :tree-data="materialtypeOptions"
          placeholder="请选择"
          :replaceFields="{children:'children', title:'typeName', key:'materialTypeId', value: 'materialTypeId' }"
          tree-default-expand-all
        >
        </a-tree-select>
      </a-form-model-item>
      <a-form-model-item label="商品名称" prop="materialName" >
        <a-input v-model="form.materialName" placeholder="请输入商品名称" />
      </a-form-model-item>
      <a-form-model-item label="制造商" prop="mfrs" >
        <a-input v-model="form.mfrs" placeholder="请输入制造商" />
      </a-form-model-item>
      <a-form-model-item label="安全存量" prop="safetyStock" >
        <a-input v-model="form.safetyStock" placeholder="请输入安全存量" />
      </a-form-model-item>
      <a-form-model-item label="型号" prop="model" >
        <a-input v-model="form.model" placeholder="请输入型号" />
      </a-form-model-item>
      <a-form-model-item label="规格" prop="standard" >
        <a-input v-model="form.standard" placeholder="请输入规格" />
      </a-form-model-item>
      <a-form-model-item label="颜色" prop="color" >
        <a-input v-model="form.color" placeholder="请输入颜色" />
      </a-form-model-item>
      <a-form-model-item label="单位" prop="unit" >
        <a-input v-model="form.unit" placeholder="请输入单位-单个" />
      </a-form-model-item>
<!--      <a-form-model-item  label="图片名称" prop="imgName" >-->
<!--        <a-input v-model="form.imgName" placeholder="请输入内容" type="textarea" allow-clear />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="计量单位名称(Id)" prop="unitId" >
        <a-select placeholder="请输入计量单位名称(Id)" v-model="form.unitId">
          <a-select-option v-for="(d, index) in unitList" :key="index" :value="d.unitId" >{{ d.unitName }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="启用" prop="enabled" >
        <a-radio-group v-model="form.enabled" button-style="solid">
          <a-radio-button v-for="(status , index) in statusOptions" :key="index" :value="status.dictValue">
           {{ status.dictLabel }}
          </a-radio-button>
        </a-radio-group>

      </a-form-model-item>
<!--      <a-form-model-item label="自定义1" prop="otherField1" >-->
<!--        <a-input v-model="form.otherField1" placeholder="请输入自定义1" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="自定义2" prop="otherField2" >-->
<!--        <a-input v-model="form.otherField2" placeholder="请输入自定义2" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="自定义3" prop="otherField3" >-->
<!--        <a-input v-model="form.otherField3" placeholder="请输入自定义3" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="是否开启序列号" prop="enableSerialNumber" >-->
<!--        <a-input v-model="form.enableSerialNumber" placeholder="请输入是否开启序列号，0否，1是" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="租户id" prop="tenantId" >-->
<!--        <a-input v-model="form.tenantId" placeholder="请输入租户id" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="删除标记" prop="deleteFlag" >-->
<!--        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />-->
<!--      </a-form-model-item>-->
      <a-divider orientation="left">
        <b>商品扩展信息</b>
      </a-divider>
      <sub-table ref="subTable" :list="subList" @add="handleAdderpExmaterial" @delete="handleDeleteerpExmaterial" />
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
import { getMaterialinfo, addMaterialinfo, updateMaterialinfo } from '@/api/material/materialinfo'
import { listMaterialtype } from '@/api/material/materialtype'
import { listMaterialunit } from '@/api/material/materialunit'
import SubTable from './SubTable'

export default {
  name: 'CreateForm',
  components: {
    SubTable
  },
  props: {
   statusOptions: {
     type: Array,
     required: true
   }
  },
  data () {
    return {
      loading: false,
      subList: [],
      // 计量单位数据
      unitList: null,
      formTitle: '',
      // 商品类型树选项
      materialtypeOptions: [],
      // 表单参数
      query: {
        unitId: null,
        unitName: null
      },
      form: {
        materialId: null,
        materialtypeId: null,
        materialName: null,
        mfrs: null,
        safetyStock: null,
        model: null,
        standard: null,
        color: null,
        unit: null,
        remark: null,
        imgName: null,
        unitId: null,
        enabled: null,
        otherField1: null,
        otherField2: null,
        otherField3: null,
        enableSerialNumber: null,
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
    this.getTreeselect()
    listMaterialunit(this.query).then(response => {
          this.unitList = response.rows
    })
  },
  computed: {
  },
  watch: {
  },
  mounted () {
  },
  methods: {
    /** 查询菜单下拉树结构 */
    getTreeselect () {
      listMaterialtype().then(response => {
        this.materialtypeOptions = []
        const data = { materialTypeId: 0, typeName: '主目录', children: [] }
        data.children = this.handleTree(response.data, 'materialTypeId', 'parentId')
        this.materialtypeOptions.push(data)
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
        materialId: null,
        materialtypeId: null,
        materialName: null,
        mfrs: null,
        safetyStock: null,
        model: null,
        standard: null,
        color: null,
        unit: null,
        remark: null,
        imgName: null,
        unitId: null,
        enabled: null,
        otherField1: null,
        otherField2: null,
        otherField3: null,
        enableSerialNumber: null,
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
    handleAdderpExmaterial (row) {
      this.subList.push(row)
    },
    /** 删除子项操作 */
    handleDeleteerpExmaterial (index, indexs) {
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
      const materialId = row ? row.materialId : ids
      getMaterialinfo(materialId).then(response => {
        this.form = response.data
        this.subList = response.data.erpExmaterialList
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.form.erpExmaterialList = this.subList
          if (this.form.materialId !== undefined && this.form.materialId !== null) {
            updateMaterialinfo(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addMaterialinfo(this.form).then(response => {
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
