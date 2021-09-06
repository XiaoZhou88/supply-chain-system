import request from '@/utils/request'

// 查询零售出库列表
export function listRetailout (query) {
  return request({
    url: '/purchase/purchaseorder/list',
    method: 'get',
    params: query
  })
}

// 查询零售出库详细
export function getRetailout (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'get'
  })
}

// 新增零售出库
export function addRetailout (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'post',
    data: data
  })
}

// 修改零售出库
export function updateRetailout (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'put',
    data: data
  })
}

// 删除零售出库
export function delRetailout (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'delete'
  })
}

// 导出零售出库
export function exportRetailout (query) {
  return request({
    url: '/purchase/purchaseorder/export',
    method: 'get',
    params: query
  })
}
