import request from '@/utils/request'

// 查询销售订单列表
export function listSaleorder (query) {
  return request({
    url: '/purchase/purchaseorder/list',
    method: 'get',
    params: query
  })
}

// 查询销售订单详细
export function getSaleorder (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'get'
  })
}

// 新增销售订单
export function addSaleorder (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'post',
    data: data
  })
}

// 修改销售订单
export function updateSaleorder (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'put',
    data: data
  })
}

// 删除销售订单
export function delSaleorder (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'delete'
  })
}

// 导出销售订单
export function exportSaleorder (query) {
  return request({
    url: '/purchase/purchaseorder/export',
    method: 'get',
    params: query
  })
}
