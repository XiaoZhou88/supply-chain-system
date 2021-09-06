import request from '@/utils/request'

// 查询支出单列表
export function listItemout (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询支出单详细
export function getItemout (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增支出单
export function addItemout (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改支出单
export function updateItemout (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除支出单
export function delItemout (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出支出单
export function exportItemout (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
