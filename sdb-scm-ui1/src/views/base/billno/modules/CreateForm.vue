<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="最小值" prop="minValue" >
        <a-input v-model="form.minValue" placeholder="请输入最小值" />
      </a-form-model-item>
      <a-form-model-item label="最大值" prop="maxValue" >
        <a-input v-model="form.maxValue" placeholder="请输入最大值" />
      </a-form-model-item>
      <a-form-model-item label="当前值" prop="currentVal" >
        <a-input v-model="form.currentVal" placeholder="请输入当前值" />
      </a-form-model-item>
      <a-form-model-item label="增长步数" prop="incrementVal" >
        <a-input v-model="form.incrementVal" placeholder="请输入增长步数" />
      </a-form-model-item>
      <a-form-model-item label="备注" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入内容" type="textarea" allow-clear />
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
import { getBillno, addBillno, updateBillno } from '@/api/base/billno'

export default {
  name: 'CreateForm',
  props: {
  },
  components: {
  },
  data () {
    return {
      loading: false,
      formTitle: '',
      // 表单参数
      form: {
        seqName: null,
        minValue: null,
        maxValue: null,
        currentVal: null,
        incrementVal: null,
        remark: null
      },
      // 1增加,2修改
      formType: 1,
      open: false,
      rules: {
        minValue: [
          { required: true, message: '最小值不能为空', trigger: 'blur' }
        ],
        maxValue: [
          { required: true, message: '最大值不能为空', trigger: 'blur' }
        ],
        currentVal: [
          { required: true, message: '当前值不能为空', trigger: 'blur' }
        ],
        incrementVal: [
          { required: true, message: '增长步数不能为空', trigger: 'blur' }
        ]
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
        seqName: null,
        minValue: null,
        maxValue: null,
        currentVal: null,
        incrementVal: null,
        remark: null
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
      const seqName = row ? row.seqName : ids
      getBillno(seqName).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.seqName !== undefined && this.form.seqName !== null) {
            updateBillno(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addBillno(this.form).then(response => {
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
