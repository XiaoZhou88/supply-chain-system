package com.sdb.scm.material.mapper;

import java.util.List;
import com.sdb.scm.material.domain.ErpMaterial;
import com.sdb.scm.material.domain.ErpExmaterial;

/**
 * 商品信息Mapper接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface ErpMaterialMapper 
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
     * 删除商品信息
     * 
     * @param materialId 商品信息ID
     * @return 结果
     */
    public int deleteErpMaterialById(Long materialId);

    /**
     * 批量删除商品信息
     * 
     * @param materialIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpMaterialByIds(Long[] materialIds);

    /**
     * 批量删除商品扩展信息
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpExmaterialByMaterialIds(Long[] materialIds);
    
    /**
     * 批量新增商品扩展信息
     * 
     * @param erpExmaterialList 商品扩展信息列表
     * @return 结果
     */
    public int batchErpExmaterial(List<ErpExmaterial> erpExmaterialList);
    

    /**
     * 通过商品信息ID删除商品扩展信息信息
     * 
     * @param materialId 商品信息ID
     * @return 结果
     */
    public int deleteErpExmaterialByMaterialId(Long materialId);
}
