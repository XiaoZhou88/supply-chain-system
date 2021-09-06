import request from '@/utils/request'

// 查询供应商信息列表
export function listSupplier (query) {
  return request({
    url: '/base/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供应商信息详细
export function getSupplier (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增供应商信息
export function addSupplier (data) {
  return request({
    url: '/base/supplier',
    method: 'post',
    data: data
  })
}

// 修改供应商信息
export function updateSupplier (data) {
  return request({
    url: '/base/supplier',
    method: 'put',
    data: data
  })
}

// 删除供应商信息
export function delSupplier (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'delete'
  })
}

// 导出供应商信息
export function exportSupplier (query) {
  return request({
    url: '/base/supplier/export',
    method: 'get',
    params: query
  })
}

// 查询客户信息列表
export function listCustomer (query) {
  return request({
    url: '/base/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询客户信息详细
export function getCustomer (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增客户信息
export function addCustomer (data) {
  return request({
    url: '/base/supplier',
    method: 'post',
    data: data
  })
}

// 修改客户信息
export function updateCustomer (data) {
  return request({
    url: '/base/supplier',
    method: 'put',
    data: data
  })
}

// 删除客户信息
export function delCustomer (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'delete'
  })
}

// 导出客户信息
export function exportCustomer (query) {
  return request({
    url: '/base/supplier/export',
    method: 'get',
    params: query
  })
}

// 查询会员信息列表
export function listMember (query) {
  return request({
    url: '/base/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询会员信息详细
export function getMember (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增会员信息
export function addMember (data) {
  return request({
    url: '/base/supplier',
    method: 'post',
    data: data
  })
}

// 修改会员信息
export function updateMember (data) {
  return request({
    url: '/base/supplier',
    method: 'put',
    data: data
  })
}

// 删除会员信息
export function delMember (supplierId) {
  return request({
    url: '/base/supplier/' + supplierId,
    method: 'delete'
  })
}

// 导出会员信息
export function exportMember (query) {
  return request({
    url: '/base/supplier/export',
    method: 'get',
    params: query
  })
}
