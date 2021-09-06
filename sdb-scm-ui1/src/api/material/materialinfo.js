import request from '@/utils/request'

// 查询商品信息列表
export function listMaterialinfo (query) {
  return request({
    url: '/material/materialinfo/list',
    method: 'get',
    params: query
  })
}

// 查询商品信息详细
export function getMaterialinfo (materialId) {
  return request({
    url: '/material/materialinfo/' + materialId,
    method: 'get'
  })
}

// 新增商品信息
export function addMaterialinfo (data) {
  return request({
    url: '/material/materialinfo',
    method: 'post',
    data: data
  })
}

// 修改商品信息
export function updateMaterialinfo (data) {
  return request({
    url: '/material/materialinfo',
    method: 'put',
    data: data
  })
}

// 删除商品信息
export function delMaterialinfo (materialId) {
  return request({
    url: '/material/materialinfo/' + materialId,
    method: 'delete'
  })
}

// 导出商品信息
export function exportMaterialinfo (query) {
  return request({
    url: '/material/materialinfo/export',
    method: 'get',
    params: query
  })
}
