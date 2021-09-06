<template>
  <!-- 增加修改 -->
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>进销存单据子</b>
    </a-divider>
    <a-form-model ref="form" :model="form">
      <a-form-model-item label="商品Id" prop="materialId">
        <a-select v-model="form.materialId" placeholder="请输入" >
          <a-select-option v-for="(supplier, index) in supplierList" :key="index" :value="supplier.supplierId">
            {{supplier.supplierName}}
          </a-select-option>
        </a-select>
      </a-form-model-item>
<!--      <a-form-model-item label="商品扩展id" prop="materialExtendId">-->
<!--        <a-input v-model="form.materialExtendId" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="商品计量单位" prop="materialUnit">
        <a-select v-model="form.materialUnit" placeholder="请输入">
          <a-select-option v-for="(unit, index ) in materialUnitList" :key="index"  :value="unit.unitId">
            {{ unit.unitName }}
          </a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="数量" prop="operNumber">
        <a-input v-model="form.operNumber" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="基础数量，如kg、瓶" prop="basicNumber">
        <a-input v-model="form.basicNumber" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="含税单价" prop="taxUnitPrice">
        <a-input v-model="form.taxUnitPrice" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="金额" prop="allPrice">
        <a-input v-model="form.allPrice" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark">
        <a-input v-model="form.remark" placeholder="请输入" />
      </a-form-model-item>
<!--      <a-form-model-item label="图片" prop="img">-->
<!--        <a-input v-model="form.img" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="运杂费" prop="incidentals">
        <a-input v-model="form.incidentals" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="仓库ID" prop="depotId">
        <a-select v-model="form.depotId" placeholder="请输入" >
          <a-select-option v-for="(deposit, index) in depositList" :key="index" :value="deposit.depositId">
            {{ deposit.depositName }}
          </a-select-option>
        </a-select>
      </a-form-model-item>
<!--      <a-form-model-item label="调拨时，对方仓库Id" prop="anotherDepotId">-->
<!--        <a-input v-model="form.anotherDepotId" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="税率" prop="taxRate">
        <a-input v-model="form.taxRate" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="税额" prop="taxMoney">
        <a-input v-model="form.taxMoney" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="价税合计" prop="taxLastMoney">
        <a-input v-model="form.taxLastMoney" placeholder="请输入" />
      </a-form-model-item>
<!--      <a-form-model-item label="自定义字段1-名称" prop="otherField1">-->
<!--        <a-input v-model="form.otherField1" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="自定义字段2-型号" prop="otherField2">-->
<!--        <a-input v-model="form.otherField2" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="自定义字段3-制造商" prop="otherField3">-->
<!--        <a-input v-model="form.otherField3" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="自定义字段4-名称" prop="otherField4">-->
<!--        <a-input v-model="form.otherField4" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="自定义字段5-名称" prop="otherField5">-->
<!--        <a-input v-model="form.otherField5" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
      <a-form-model-item label="商品类型" prop="materialType">
        <a-input v-model="form.materialType" placeholder="请输入" />
      </a-form-model-item>
<!--      <a-form-model-item label="租户id" prop="tenantId">-->
<!--        <a-input v-model="form.tenantId" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item label="删除标记，0未删除，1删除" prop="deleteFlag">-->
<!--        <a-input v-model="form.deleteFlag" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
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
import { listSupplier } from '@/api/base/supplier'
import { listMaterialunit } from '@/api/material/materialunit'
import { listDeposit } from '@/api/base/deposit'
export default {
  name: 'CreateSubForm',
  props: {
  },
  components: {
  },
  data () {
    return {
      formTitle: '增加',
      // 供应商数据
      supplierList: null,
      // 商品的记录单位
      materialUnitList: null,
      // 仓库的数据
      depositList: null,
      // 表单参数
      query: {
        supplierId: null,
        supplierName: null,
        type: '0'
      },
      query2: {
        unitId: null,
        unitName: null
      },
      query3: {
        depositId: null,
        depositName: null
      },
      form: {
        materialId: undefined,
        materialExtendId: undefined,
        materialUnit: undefined,
        operNumber: undefined,
        basicNumber: undefined,
        taxUnitPrice: undefined,
        allPrice: undefined,
        remark: undefined,
        img: undefined,
        incidentals: undefined,
        depotId: undefined,
        anotherDepotId: undefined,
        taxRate: undefined,
        taxMoney: undefined,
        taxLastMoney: undefined,
        otherField1: undefined,
        otherField2: undefined,
        otherField3: undefined,
        otherField4: undefined,
        otherField5: undefined,
        materialType: undefined,
        tenantId: undefined,
        deleteFlag: undefined
      },
      open: false
    }
  },
  filters: {
  },
  created () {
    listSupplier(this.query).then(response => {
      this.supplierList = response.rows
    })
    listMaterialunit(this.query2).then(response => {
      this.materialUnitList = response.rows
    })
    listDeposit(this.query3).then(response => {
      this.depositList = response.rows
    })
  },
  computed: {
  },
  watch: {
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
      this.form = {
        materialId: undefined,
        materialExtendId: undefined,
        materialUnit: undefined,
        operNumber: undefined,
        basicNumber: undefined,
        taxUnitPrice: undefined,
        allPrice: undefined,
        remark: undefined,
        img: undefined,
        incidentals: undefined,
        depotId: undefined,
        anotherDepotId: undefined,
        taxRate: undefined,
        taxMoney: undefined,
        taxLastMoney: undefined,
        otherField1: undefined,
        otherField2: undefined,
        otherField3: undefined,
        otherField4: undefined,
        otherField5: undefined,
        materialType: undefined,
        tenantId: undefined,
        deleteFlag: undefined
      }
    },
     /** 新增按钮操作 */
    handleAdd () {
      this.open = true
      this.reset()
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$emit('add', this.form)
      this.open = false
    }
  }
}
</script>
