import request from '@/utils/request'

// 查询商品类型列表
export function listMaterialtype (query) {
  return request({
    url: '/material/materialtype/list',
    method: 'get',
    params: query
  })
}

// 查询商品类型详细
export function getMaterialtype (materialTypeId) {
  return request({
    url: '/material/materialtype/' + materialTypeId,
    method: 'get'
  })
}

// 查询商品类型下拉树结构
export function typetreeselect () {
  return request({
    url: '/material/materialtype/treeselect',
    method: 'get'
  })
}

// 新增商品类型
export function addMaterialtype (data) {
  return request({
    url: '/material/materialtype',
    method: 'post',
    data: data
  })
}

// 修改商品类型
export function updateMaterialtype (data) {
  return request({
    url: '/material/materialtype',
    method: 'put',
    data: data
  })
}

// 删除商品类型
export function delMaterialtype (materialTypeId) {
  return request({
    url: '/material/materialtype/' + materialTypeId,
    method: 'delete'
  })
}

// 导出商品类型
export function exportMaterialtype (query) {
  return request({
    url: '/material/materialtype/export',
    method: 'get',
    params: query
  })
}
