import request from '@/utils/request'

// 查询收入单列表
export function listItemin (query) {
  return request({
    url: '/financial/itemin/list',
    method: 'get',
    params: query
  })
}

// 查询收入单详细
export function getItemin (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'get'
  })
}

// 新增收入单
export function addItemin (data) {
  return request({
    url: '/financial/itemin',
    method: 'post',
    data: data
  })
}

// 修改收入单
export function updateItemin (data) {
  return request({
    url: '/financial/itemin',
    method: 'put',
    data: data
  })
}

// 删除收入单
export function delItemin (accountHeadId) {
  return request({
    url: '/financial/itemin/' + accountHeadId,
    method: 'delete'
  })
}

// 导出收入单
export function exportItemin (query) {
  return request({
    url: '/financial/itemin/export',
    method: 'get',
    params: query
  })
}
