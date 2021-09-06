import request from '@/utils/request'

// 查询计量单位列表
export function listMaterialunit (query) {
  return request({
    url: '/material/materialunit/list',
    method: 'get',
    params: query
  })
}

// 查询计量单位详细
export function getMaterialunit (unitId) {
  return request({
    url: '/material/materialunit/' + unitId,
    method: 'get'
  })
}

// 新增计量单位
export function addMaterialunit (data) {
  return request({
    url: '/material/materialunit',
    method: 'post',
    data: data
  })
}

// 修改计量单位
export function updateMaterialunit (data) {
  return request({
    url: '/material/materialunit',
    method: 'put',
    data: data
  })
}

// 删除计量单位
export function delMaterialunit (unitId) {
  return request({
    url: '/material/materialunit/' + unitId,
    method: 'delete'
  })
}

// 导出计量单位
export function exportMaterialunit (query) {
  return request({
    url: '/material/materialunit/export',
    method: 'get',
    params: query
  })
}
