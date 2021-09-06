<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="库位编码" prop="storesiteCode" >
        <a-input v-model="form.storesiteCode" placeholder="请输入库位编码" />
      </a-form-model-item>
      <a-form-model-item label="库位名称" prop="storesiteName" >
        <a-input v-model="form.storesiteName" placeholder="请输入库位名称" />
      </a-form-model-item>
      <a-form-model-item label="库位条码" prop="storesiteBarcode" >
        <a-input v-model="form.storesiteBarcode" placeholder="请输入库位条码" />
      </a-form-model-item>
      <a-form-model-item label="所属库区" prop="regionId" >
        <a-select placeholder="所属库区" v-model="form.regionId">
          <a-select-option v-for="(d, index) in regionList" :key="index" :value="d.depositRegionId" >{{ d.regionName }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="库位类型" prop="storeType" >
        <a-select placeholder="请选择库位类型(数据字典：收货、发货、存储、暂存、良品、不良等)" v-model="form.storeType">
          <a-select-option v-for="(d, index) in storeTypeOptions" :key="index" :value="d.dictValue" >{{ d.dictLabel }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="库位属性" prop="storeAttribute" >
        <a-select placeholder="请选择库位属性(数据字典：冷藏、恒温、常温等)" v-model="form.storeAttribute">
          <a-select-option v-for="(d, index) in storeAttributeOptions" :key="index" :value="d.dictValue" >{{ d.dictLabel }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="库位尺寸" prop="storeSizeId" >
        <a-input v-model="form.storeSizeId" placeholder="请输入库位尺寸主键" />
      </a-form-model-item>
      <a-form-model-item label="出库口" prop="outbound" >
        <a-input v-model="form.outbound" placeholder="请输入出库口" />
      </a-form-model-item>
      <a-form-model-item label="空库位标识" prop="isEmpty" >
        <a-input v-model="form.isEmpty" placeholder="请输入空库位标识(Y是 N否)" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="是否停用" prop="isDisable" >
        <a-input v-model="form.isDisable" placeholder="请输入是否停用(0:正常 1:停用)" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标志" prop="delFlag" v-if="formType === 1">
        <a-input v-model="form.delFlag" placeholder="请输入删除标志" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="租户ID" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户ID" />
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
import { getStoresite, addStoresite, updateStoresite } from '@/api/base/storesite'
import { listRegion } from '@/api/base/storeregion'
export default {
  name: 'CreateForm',
  props: {
    storeTypeOptions: {
      type: Array,
      required: true
    },
    storeAttributeOptions: {
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
      regionList: null,
      query: {
        depositRegionId: null,
        regionName: null
      },
      // 表单参数
      form: {
        depositStoresiteId: null,
        storesiteCode: null,
        storesiteName: null,
        storesiteBarcode: null,
        regionId: null,
        storeType: null,
        storeAttribute: null,
        storeSizeId: null,
        outbound: null,
        isEmpty: null,
        isDisable: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tenantId: null
      },
      // 1增加,2修改
      formType: 1,
      open: false,
      rules: {
        tenantId: [
          { required: true, message: '租户ID不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  filters: {
  },
  created () {
    listRegion(this.query).then(response => {
      this.regionList = response.rows
      // console.log(this.regionList);
    })
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
        depositStoresiteId: null,
        storesiteCode: null,
        storesiteName: null,
        storesiteBarcode: null,
        regionId: null,
        storeType: null,
        storeAttribute: null,
        storeSizeId: null,
        outbound: null,
        isEmpty: null,
        isDisable: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        tenantId: null
      }
    },
    /** 新增按钮操作 */
    handleAdd (row) {
      this.reset()
      this.formType = 1
      this.open = true
      this.formTitle = '添加'
    },
    /** 修改按钮操作 */
    handleUpdate (row, ids) {
      this.reset()
      this.formType = 2
      const depositStoresiteId = row ? row.depositStoresiteId : ids
      getStoresite(depositStoresiteId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.depositStoresiteId !== undefined && this.form.depositStoresiteId !== null) {
            updateStoresite(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addStoresite(this.form).then(response => {
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
