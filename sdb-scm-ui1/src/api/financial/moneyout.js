import request from '@/utils/request'

// 查询付款单列表
export function listMoneyout (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询付款单详细
export function getMoneyout (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增付款单
export function addMoneyout (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改付款单
export function updateMoneyout (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除付款单
export function delMoneyout (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出付款单
export function exportMoneyout (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
