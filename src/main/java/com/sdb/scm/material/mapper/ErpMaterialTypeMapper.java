package com.sdb.scm.material.mapper;

import java.util.List;
import com.sdb.scm.material.domain.ErpMaterialType;

/**
 * 商品类型Mapper接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface ErpMaterialTypeMapper 
{
    /**
     * 查询商品类型
     * 
     * @param materialTypeId 商品类型ID
     * @return 商品类型
     */
    public ErpMaterialType selectErpMaterialTypeById(Long materialTypeId);

    /**
     * 查询商品类型列表
     * 
     * @param erpMaterialType 商品类型
     * @return 商品类型集合
     */
    public List<ErpMaterialType> selectErpMaterialTypeList(ErpMaterialType erpMaterialType);

    /**
     * 新增商品类型
     * 
     * @param erpMaterialType 商品类型
     * @return 结果
     */
    public int insertErpMaterialType(ErpMaterialType erpMaterialType);

    /**
     * 修改商品类型
     * 
     * @param erpMaterialType 商品类型
     * @return 结果
     */
    public int updateErpMaterialType(ErpMaterialType erpMaterialType);

    /**
     * 删除商品类型
     * 
     * @param materialTypeId 商品类型ID
     * @return 结果
     */
    public int deleteErpMaterialTypeById(Long materialTypeId);

    /**
     * 批量删除商品类型
     * 
     * @param materialTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpMaterialTypeByIds(Long[] materialTypeIds);
}
