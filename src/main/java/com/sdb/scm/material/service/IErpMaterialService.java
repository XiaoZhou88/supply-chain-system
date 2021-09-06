package com.sdb.scm.material.service;

import java.util.List;
import com.sdb.scm.material.domain.ErpMaterial;

/**
 * 商品信息Service接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface IErpMaterialService 
{
    /**
     * 查询商品信息
     * 
     * @param materialId 商品信息ID
     * @return 商品信息
     */
    public ErpMaterial selectErpMaterialById(Long materialId);

    /**
     * 查询商品信息列表
     * 
     * @param erpMaterial 商品信息
     * @return 商品信息集合
     */
    public List<ErpMaterial> selectErpMaterialList(ErpMaterial erpMaterial);

    /**
     * 新增商品信息
     * 
     * @param erpMaterial 商品信息
     * @return 结果
     */
    public int insertErpMaterial(ErpMaterial erpMaterial);

    /**
     * 修改商品信息
     * 
     * @param erpMaterial 商品信息
     * @return 结果
     */
    public int updateErpMaterial(ErpMaterial erpMaterial);

    /**
     * 批量删除商品信息
     * 
     * @param materialIds 需要删除的商品信息ID
     * @return 结果
     */
    public int deleteErpMaterialByIds(Long[] materialIds);

    /**
     * 删除商品信息信息
     * 
     * @param materialId 商品信息ID
     * @return 结果
     */
    public int deleteErpMaterialById(Long materialId);
}
