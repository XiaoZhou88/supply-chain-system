import request from '@/utils/request'

// 查询仓库列表
export function listDeposit (query) {
  return request({
    url: '/base/deposit/list',
    method: 'get',
    params: query
  })
}

// 查询仓库详细
export function getDeposit (depositId) {
  return request({
    url: '/base/deposit/' + depositId,
    method: 'get'
  })
}

// 新增仓库
export function addDeposit (data) {
  return request({
    url: '/base/deposit',
    method: 'post',
    data: data
  })
}

// 修改仓库
export function updateDeposit (data) {
  return request({
    url: '/base/deposit',
    method: 'put',
    data: data
  })
}

// 删除仓库
export function delDeposit (depositId) {
  return request({
    url: '/base/deposit/' + depositId,
    method: 'delete'
  })
}

// 导出仓库
export function exportDeposit (query) {
  return request({
    url: '/base/deposit/export',
    method: 'get',
    params: query
  })
}
