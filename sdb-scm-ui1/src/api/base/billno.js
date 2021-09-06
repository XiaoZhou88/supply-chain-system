import request from '@/utils/request'

// 查询单据编号列表
export function listBillno (query) {
  return request({
    url: '/base/billno/list',
    method: 'get',
    params: query
  })
}

// 查询单据编号详细
export function getBillno (seqName) {
  return request({
    url: '/base/billno/' + seqName,
    method: 'get'
  })
}

// 新增单据编号
export function addBillno (data) {
  return request({
    url: '/base/billno',
    method: 'post',
    data: data
  })
}

// 修改单据编号
export function updateBillno (data) {
  return request({
    url: '/base/billno',
    method: 'put',
    data: data
  })
}

// 删除单据编号
export function delBillno (seqName) {
  return request({
    url: '/base/billno/' + seqName,
    method: 'delete'
  })
}

// 导出单据编号
export function exportBillno (query) {
  return request({
    url: '/base/billno/export',
    method: 'get',
    params: query
  })
}
