import request from '@/utils/request'

// 查询采购订单列表
export function listPurchaseorder (query) {
  return request({
    url: '/purchase/purchaseorder/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单详细
export function getPurchaseorder (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'get'
  })
}

// 新增采购订单
export function addPurchaseorder (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'post',
    data: data
  })
}

// 修改采购订单
export function updatePurchaseorder (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'put',
    data: data
  })
}

// 删除采购订单
export function delPurchaseorder (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'delete'
  })
}

// 导出采购订单
export function exportPurchaseorder (query) {
  return request({
    url: '/purchase/purchaseorder/export',
    method: 'get',
    params: query
  })
}
