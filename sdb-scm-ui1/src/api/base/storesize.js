import request from '@/utils/request'

// 查询库位尺寸列表
export function listStoresize (query) {
  return request({
    url: '/base/storesize/list',
    method: 'get',
    params: query
  })
}

// 查询库位尺寸详细
export function getStoresize (storesizeId) {
  return request({
    url: '/base/storesize/' + storesizeId,
    method: 'get'
  })
}

// 新增库位尺寸
export function addStoresize (data) {
  return request({
    url: '/base/storesize',
    method: 'post',
    data: data
  })
}

// 修改库位尺寸
export function updateStoresize (data) {
  return request({
    url: '/base/storesize',
    method: 'put',
    data: data
  })
}

// 删除库位尺寸
export function delStoresize (storesizeId) {
  return request({
    url: '/base/storesize/' + storesizeId,
    method: 'delete'
  })
}

// 导出库位尺寸
export function exportStoresize (query) {
  return request({
    url: '/base/storesize/export',
    method: 'get',
    params: query
  })
}
