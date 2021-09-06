import request from '@/utils/request'

// 查询库位设置列表
export function listStoresite (query) {
  return request({
    url: '/base/storesite/list',
    method: 'get',
    params: query
  })
}

// 查询库位设置详细
export function getStoresite (depositStoresiteId) {
  return request({
    url: '/base/storesite/' + depositStoresiteId,
    method: 'get'
  })
}

// 新增库位设置
export function addStoresite (data) {
  return request({
    url: '/base/storesite',
    method: 'post',
    data: data
  })
}

// 修改库位设置
export function updateStoresite (data) {
  return request({
    url: '/base/storesite',
    method: 'put',
    data: data
  })
}

// 删除库位设置
export function delStoresite (depositStoresiteId) {
  return request({
    url: '/base/storesite/' + depositStoresiteId,
    method: 'delete'
  })
}

// 导出库位设置
export function exportStoresite (query) {
  return request({
    url: '/base/storesite/export',
    method: 'get',
    params: query
  })
}
