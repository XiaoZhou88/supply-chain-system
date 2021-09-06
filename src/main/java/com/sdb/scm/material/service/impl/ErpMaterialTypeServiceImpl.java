package com.sdb.scm.material.service.impl;

import java.util.List;

import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.material.mapper.ErpMaterialTypeMapper;
import com.sdb.scm.material.domain.ErpMaterialType;
import com.sdb.scm.material.service.IErpMaterialTypeService;

/**
 * 商品类型Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-14
 */
@Service
public class ErpMaterialTypeServiceImpl implements IErpMaterialTypeService 
{
    @Autowired
    private ErpMaterialTypeMapper erpMaterialTypeMapper;

    /**
     * 查询商品类型
     * 
     * @param materialTypeId 商品类型ID
     * @return 商品类型
     */
    @Override
    public ErpMaterialType selectErpMaterialTypeById(Long materialTypeId)
    {
        return erpMaterialTypeMapper.selectErpMaterialTypeById(materialTypeId);
    }

    /**
     * 查询商品类型列表
     * 
     * @param erpMaterialType 商品类型
     * @return 商品类型
     */
    @Override
    public List<ErpMaterialType> selectErpMaterialTypeList(ErpMaterialType erpMaterialType)
    {
        return erpMaterialTypeMapper.selectErpMaterialTypeList(erpMaterialType);
    }

    /**
     * 新增商品类型
     * 
     * @param erpMaterialType 商品类型
     * @return 结果
     */
    @Override
    public int insertErpMaterialType(ErpMaterialType erpMaterialType)
    {
        erpMaterialType.setCreateTime(DateUtils.getNowDate());
        return erpMaterialTypeMapper.insertErpMaterialType(erpMaterialType);
    }

    /**
     * 修改商品类型
     * 
     * @param erpMaterialType 商品类型
     * @return 结果
     */
    @Override
    public int updateErpMaterialType(ErpMaterialType erpMaterialType)
    {
        erpMaterialType.setUpdateTime(DateUtils.getNowDate());
        return erpMaterialTypeMapper.updateErpMaterialType(erpMaterialType);
    }

    /**
     * 批量删除商品类型
     * 
     * @param materialTypeIds 需要删除的商品类型ID
     * @return 结果
     */
    @Override
    public int deleteErpMaterialTypeByIds(Long[] materialTypeIds)
    {
        return erpMaterialTypeMapper.deleteErpMaterialTypeByIds(materialTypeIds);
    }

    /**
     * 删除商品类型信息
     * 
     * @param materialTypeId 商品类型ID
     * @return 结果
     */
    @Override
    public int deleteErpMaterialTypeById(Long materialTypeId)
    {
        return erpMaterialTypeMapper.deleteErpMaterialTypeById(materialTypeId);
    }

}
