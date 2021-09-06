import request from '@/utils/request'

// 查询收预付款单列表
export function listMoneyadvance (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询收预付款单详细
export function getMoneyadvance (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增收预付款单
export function addMoneyadvance (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改收预付款单
export function updateMoneyadvance (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除收预付款单
export function delMoneyadvance (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出收预付款单
export function exportMoneyadvance (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
