package com.sdb.scm.material.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.material.mapper.ErpUnitMapper;
import com.sdb.scm.material.domain.ErpUnit;
import com.sdb.scm.material.service.IErpUnitService;

/**
 * 计量单位Service业务层处理
 * 
 * @author jzg
 * @date 2021-08-14
 */
@Service
public class ErpUnitServiceImpl implements IErpUnitService 
{
    @Autowired
    private ErpUnitMapper erpUnitMapper;

    /**
     * 查询计量单位
     * 
     * @param unitId 计量单位ID
     * @return 计量单位
     */
    @Override
    public ErpUnit selectErpUnitById(Long unitId)
    {
        return erpUnitMapper.selectErpUnitById(unitId);
    }

    /**
     * 查询计量单位列表
     * 
     * @param erpUnit 计量单位
     * @return 计量单位
     */
    @Override
    public List<ErpUnit> selectErpUnitList(ErpUnit erpUnit)
    {
        return erpUnitMapper.selectErpUnitList(erpUnit);
    }

    /**
     * 新增计量单位
     * 
     * @param erpUnit 计量单位
     * @return 结果
     */
    @Override
    public int insertErpUnit(ErpUnit erpUnit)
    {
        return erpUnitMapper.insertErpUnit(erpUnit);
    }

    /**
     * 修改计量单位
     * 
     * @param erpUnit 计量单位
     * @return 结果
     */
    @Override
    public int updateErpUnit(ErpUnit erpUnit)
    {
        return erpUnitMapper.updateErpUnit(erpUnit);
    }

    /**
     * 批量删除计量单位
     * 
     * @param unitIds 需要删除的计量单位ID
     * @return 结果
     */
    @Override
    public int deleteErpUnitByIds(Long[] unitIds)
    {
        return erpUnitMapper.deleteErpUnitByIds(unitIds);
    }

    /**
     * 删除计量单位信息
     * 
     * @param unitId 计量单位ID
     * @return 结果
     */
    @Override
    public int deleteErpUnitById(Long unitId)
    {
        return erpUnitMapper.deleteErpUnitById(unitId);
    }
}
