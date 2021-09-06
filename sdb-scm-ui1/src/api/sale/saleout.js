import request from '@/utils/request'

// 查询销售出库列表
export function listSaleout (query) {
  return request({
    url: '/purchase/purchaseorder/list',
    method: 'get',
    params: query
  })
}

// 查询销售出库详细
export function getSaleout (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'get'
  })
}

// 新增销售出库
export function addSaleout (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'post',
    data: data
  })
}

// 修改销售出库
export function updateSaleout (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'put',
    data: data
  })
}

// 删除销售出库
export function delSaleout (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'delete'
  })
}

// 导出销售出库
export function exportSaleout (query) {
  return request({
    url: '/purchase/purchaseorder/export',
    method: 'get',
    params: query
  })
}
