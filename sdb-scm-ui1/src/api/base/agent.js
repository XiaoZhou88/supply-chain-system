import request from '@/utils/request'

// 查询经办人列表
export function listAgent (query) {
  return request({
    url: '/base/agent/list',
    method: 'get',
    params: query
  })
}

// 查询经办人详细
export function getAgent (agentId) {
  return request({
    url: '/base/agent/' + agentId,
    method: 'get'
  })
}

// 新增经办人
export function addAgent (data) {
  return request({
    url: '/base/agent',
    method: 'post',
    data: data
  })
}

// 修改经办人
export function updateAgent (data) {
  return request({
    url: '/base/agent',
    method: 'put',
    data: data
  })
}

// 删除经办人
export function delAgent (agentId) {
  return request({
    url: '/base/agent/' + agentId,
    method: 'delete'
  })
}

// 导出经办人
export function exportAgent (query) {
  return request({
    url: '/base/agent/export',
    method: 'get',
    params: query
  })
}
