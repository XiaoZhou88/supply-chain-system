import request from '@/utils/request'

// 查询账户信息列表
export function listAccount (query) {
  return request({
    url: '/base/account/list',
    method: 'get',
    params: query
  })
}

// 查询账户信息详细
export function getAccount (accountId) {
  return request({
    url: '/base/account/' + accountId,
    method: 'get'
  })
}

// 新增账户信息
export function addAccount (data) {
  return request({
    url: '/base/account',
    method: 'post',
    data: data
  })
}

// 修改账户信息
export function updateAccount (data) {
  return request({
    url: '/base/account',
    method: 'put',
    data: data
  })
}

// 删除账户信息
export function delAccount (accountId) {
  return request({
    url: '/base/account/' + accountId,
    method: 'delete'
  })
}

// 导出账户信息
export function exportAccount (query) {
  return request({
    url: '/base/account/export',
    method: 'get',
    params: query
  })
}
