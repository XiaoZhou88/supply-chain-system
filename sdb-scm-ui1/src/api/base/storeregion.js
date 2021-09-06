import request from '@/utils/request'

// 查询库区设置列表
export function listRegion (query) {
  return request({
    url: '/base/region/list',
    method: 'get',
    params: query
  })
}

// 查询库区设置详细
export function getRegion (depositRegionId) {
  return request({
    url: '/base/region/' + depositRegionId,
    method: 'get'
  })
}

// 新增库区设置
export function addRegion (data) {
  return request({
    url: '/base/region',
    method: 'post',
    data: data
  })
}

// 修改库区设置
export function updateRegion (data) {
  return request({
    url: '/base/region',
    method: 'put',
    data: data
  })
}

// 删除库区设置
export function delRegion (depositRegionId) {
  return request({
    url: '/base/region/' + depositRegionId,
    method: 'delete'
  })
}

// 导出库区设置
export function exportRegion (query) {
  return request({
    url: '/base/region/export',
    method: 'get',
    params: query
  })
}
