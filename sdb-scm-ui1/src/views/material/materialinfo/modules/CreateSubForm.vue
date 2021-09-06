<template>
  <!-- 增加修改 -->
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>商品扩展信息</b>
    </a-divider>
    <a-form-model ref="form" :model="form">
      <a-form-model-item label="商品条码" prop="barCode">
        <a-input v-model="form.barCode" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="商品单位" prop="commodityUnit">
        <a-input v-model="form.commodityUnit" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="采购价格" prop="purchaseDecimal">
        <a-input v-model="form.purchaseDecimal" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="零售价格" prop="commodityDecimal">
        <a-input v-model="form.commodityDecimal" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="销售价格" prop="wholesaleDecimal">
        <a-input v-model="form.wholesaleDecimal" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="最低售价" prop="lowDecimal">
        <a-input v-model="form.lowDecimal" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="是否为默认单位" prop="defaultFlag">
        <a-input v-model="form.defaultFlag" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="创建人" prop="createSerial">
        <a-input v-model="form.createSerial" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="更新人" prop="updateSerial">
        <a-input v-model="form.updateSerial" placeholder="请输入" />
      </a-form-model-item>
<!--      <a-form-model-item  label="租户id" prop="tenantId">-->
<!--        <a-input v-model="form.tenantId" placeholder="请输入" />-->
<!--      </a-form-model-item>-->
<!--      <a-form-model-item  label="删除标记" prop="deleteFlag">-->
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

export default {
  name: 'CreateSubForm',
  props: {
  },
  components: {
  },
  data () {
    return {
      formTitle: '增加',
      // 表单参数
      form: {
        barCode: null,
        commodityUnit: null,
        purchaseDecimal: null,
        commodityDecimal: null,
        wholesaleDecimal: null,
        lowDecimal: null
      },
      open: false
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
        barCode: null,
        commodityUnit: null,
        purchaseDecimal: null,
        commodityDecimal: null,
        wholesaleDecimal: null,
        lowDecimal: null
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
