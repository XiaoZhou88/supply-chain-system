import request from '@/utils/request'

// 查询转账单列表
export function listMoneytransfer (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询转账单详细
export function getMoneytransfer (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增转账单
export function addMoneytransfer (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改转账单
export function updateMoneytransfer (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除转账单
export function delMoneytransfer (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出转账单
export function exportMoneytransfer (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
