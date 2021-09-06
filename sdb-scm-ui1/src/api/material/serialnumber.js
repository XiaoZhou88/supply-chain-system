import request from '@/utils/request'

// 查询序列号列表
export function listSerialnumber (query) {
  return request({
    url: '/material/serialnumber/list',
    method: 'get',
    params: query
  })
}

// 查询序列号详细
export function getSerialnumber (serialId) {
  return request({
    url: '/material/serialnumber/' + serialId,
    method: 'get'
  })
}

// 新增序列号
export function addSerialnumber (data) {
  return request({
    url: '/material/serialnumber',
    method: 'post',
    data: data
  })
}

// 修改序列号
export function updateSerialnumber (data) {
  return request({
    url: '/material/serialnumber',
    method: 'put',
    data: data
  })
}

// 删除序列号
export function delSerialnumber (serialId) {
  return request({
    url: '/material/serialnumber/' + serialId,
    method: 'delete'
  })
}

// 导出序列号
export function exportSerialnumber (query) {
  return request({
    url: '/material/serialnumber/export',
    method: 'get',
    params: query
  })
}
