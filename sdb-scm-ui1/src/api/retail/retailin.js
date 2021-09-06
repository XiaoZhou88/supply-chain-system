import request from '@/utils/request'

// 查询零售入库列表
export function listRetailin (query) {
  return request({
    url: '/purchase/purchaseorder/list',
    method: 'get',
    params: query
  })
}

// 查询零售入库详细
export function getRetailin (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'get'
  })
}

// 新增零售入库
export function addRetailin (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'post',
    data: data
  })
}

// 修改零售入库
export function updateRetailin (data) {
  return request({
    url: '/purchase/purchaseorder',
    method: 'put',
    data: data
  })
}

// 删除零售入库
export function delRetailin (jxcHeadId) {
  return request({
    url: '/purchase/purchaseorder/' + jxcHeadId,
    method: 'delete'
  })
}

// 导出零售入库
export function exportRetailin (query) {
  return request({
    url: '/purchase/purchaseorder/export',
    method: 'get',
    params: query
  })
}
