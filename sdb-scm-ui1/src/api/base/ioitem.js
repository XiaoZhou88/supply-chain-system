import request from '@/utils/request'

// 查询收支项目列表
export function listIoitem (query) {
  return request({
    url: '/base/ioitem/list',
    method: 'get',
    params: query
  })
}

// 查询收支项目详细
export function getIoitem (ioitemId) {
  return request({
    url: '/base/ioitem/' + ioitemId,
    method: 'get'
  })
}

// 新增收支项目
export function addIoitem (data) {
  return request({
    url: '/base/ioitem',
    method: 'post',
    data: data
  })
}

// 修改收支项目
export function updateIoitem (data) {
  return request({
    url: '/base/ioitem',
    method: 'put',
    data: data
  })
}

// 删除收支项目
export function delIoitem (ioitemId) {
  return request({
    url: '/base/ioitem/' + ioitemId,
    method: 'delete'
  })
}

// 导出收支项目
export function exportIoitem (query) {
  return request({
    url: '/base/ioitem/export',
    method: 'get',
    params: query
  })
}
