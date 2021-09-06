<template>
  <a-drawer width="35%" :label-col="4" :wrapper-col="14" :visible="open" @close="onClose">
    <a-divider orientation="left">
      <b>{{ formTitle }}</b>
    </a-divider>
    <a-form-model ref="form" :model="form" :rules="rules">
      <a-form-model-item label="仓库名称" prop="depositName" >
        <a-input v-model="form.depositName" placeholder="请输入仓库名称" />
      </a-form-model-item>
      <a-form-model-item label="仓库地址" prop="address" >
        <a-input v-model="form.address" placeholder="请输入仓库地址" />
      </a-form-model-item>
      <a-form-model-item label="仓储费" prop="warehousing" >
        <a-input v-model="form.warehousing" placeholder="请输入仓储费" />
      </a-form-model-item>
      <a-form-model-item label="搬运费" prop="truckage" >
        <a-input v-model="form.truckage" placeholder="请输入搬运费" />
      </a-form-model-item>
      <a-form-model-item label="类型" prop="type" >
        <a-select placeholder="请选择类型" v-model="form.type">
          <a-select-option v-for="(d, index) in typeOptions" :key="index" :value="d.dictValue" >{{ d.dictLabel }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="排序" prop="sort" >
        <a-input v-model="form.sort" placeholder="请输入排序" />
      </a-form-model-item>
      <a-form-model-item label="描述" prop="remark" >
        <a-input v-model="form.remark" placeholder="请输入描述" />
      </a-form-model-item>

      <a-form-model-item label="负责人" prop="principal" >
        <a-select v-model="form.principal" >
          <a-select-option v-for="(user, index) in userList" :key="index" :value="user.userId">
            {{ user.userName }}
          </a-select-option>
        </a-select>
      </a-form-model-item>

      <a-form-model-item v-show="false" label="租户id" prop="tenantId" >
        <a-input v-model="form.tenantId" placeholder="请输入租户id" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="删除标记" prop="deleteFlag" >
        <a-input v-model="form.deleteFlag" placeholder="请输入删除标记，0未删除，1删除" />
      </a-form-model-item>
      <a-form-model-item v-show="false" label="是否默认" prop="isDefault" >
        <a-input v-model="form.isDefault" placeholder="请输入是否默认" />
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
import { getDeposit, addDeposit, updateDeposit } from '@/api/base/deposit'
import { listUser } from '@/api/system/user'

export default {
  name: 'CreateForm',
  props: {
    typeOptions: {
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
      userList: null,
      userModel: null,
      deptList: null,
      dept: null,
      deptSelected: null,
      query: {
        userName: null,
        deptId: null,
        userId: null
      },
      // 表单参数
      form: {
        depositId: null,
        depositName: null,
        address: null,
        warehousing: null,
        truckage: null,
        type: null,
        sort: null,
        remark: null,
        principal: null,
        tenantId: null,
        deleteFlag: null,
        isDefault: null
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
    listUser(this.query).then(response => {
      this.userList = response.rows
      // for (let item of this.userList) {
      //   console.log(item + '---' + this.userList[item].userId + '---' + this.userList[item].userName)
      // }
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
        depositId: null,
        depositName: null,
        address: null,
        warehousing: null,
        truckage: null,
        type: null,
        sort: null,
        remark: null,
        principal: null,
        tenantId: null,
        deleteFlag: null,
        isDefault: null
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
      const depositId = row ? row.depositId : ids
      getDeposit(depositId).then(response => {
        this.form = response.data
        this.open = true
        this.formTitle = '修改'
      })
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.depositId !== undefined && this.form.depositId !== null) {
            updateDeposit(this.form).then(response => {
              this.$message.success(
                '修改成功',
                3
              )
              this.open = false
              this.$emit('ok')
            })
          } else {
            addDeposit(this.form).then(response => {
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
