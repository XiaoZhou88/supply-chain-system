import request from '@/utils/request'

// 查询收款单列表
export function listMoneyin (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询收款单详细
export function getMoneyin (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增收款单
export function addMoneyin (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改收款单
export function updateMoneyin (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除收款单
export function delMoneyin (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出收款单
export function exportMoneyin (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
