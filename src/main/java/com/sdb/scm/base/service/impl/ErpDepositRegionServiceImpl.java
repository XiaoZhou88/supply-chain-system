package com.sdb.scm.base.service.impl;

import java.util.List;
import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpDepositRegionMapper;
import com.sdb.scm.base.domain.ErpDepositRegion;
import com.sdb.scm.base.service.IErpDepositRegionService;

/**
 * 库区设置Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-13
 */
@Service
public class ErpDepositRegionServiceImpl implements IErpDepositRegionService 
{
    @Autowired
    private ErpDepositRegionMapper erpDepositRegionMapper;

    /**
     * 查询库区设置
     * 
     * @param depositRegionId 库区设置ID
     * @return 库区设置
     */
    @Override
    public ErpDepositRegion selectErpDepositRegionById(Long depositRegionId)
    {
        return erpDepositRegionMapper.selectErpDepositRegionById(depositRegionId);
    }

    /**
     * 查询库区设置列表
     * 
     * @param erpDepositRegion 库区设置
     * @return 库区设置
     */
    @Override
    public List<ErpDepositRegion> selectErpDepositRegionList(ErpDepositRegion erpDepositRegion)
    {
        return erpDepositRegionMapper.selectErpDepositRegionList(erpDepositRegion);
    }

    /**
     * 新增库区设置
     * 
     * @param erpDepositRegion 库区设置
     * @return 结果
     */
    @Override
    public int insertErpDepositRegion(ErpDepositRegion erpDepositRegion)
    {
        erpDepositRegion.setCreateTime(DateUtils.getNowDate());
        return erpDepositRegionMapper.insertErpDepositRegion(erpDepositRegion);
    }

    /**
     * 修改库区设置
     * 
     * @param erpDepositRegion 库区设置
     * @return 结果
     */
    @Override
    public int updateErpDepositRegion(ErpDepositRegion erpDepositRegion)
    {
        erpDepositRegion.setUpdateTime(DateUtils.getNowDate());
        return erpDepositRegionMapper.updateErpDepositRegion(erpDepositRegion);
    }

    /**
     * 批量删除库区设置
     * 
     * @param depositRegionIds 需要删除的库区设置ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositRegionByIds(Long[] depositRegionIds)
    {
        return erpDepositRegionMapper.deleteErpDepositRegionByIds(depositRegionIds);
    }

    /**
     * 删除库区设置信息
     * 
     * @param depositRegionId 库区设置ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositRegionById(Long depositRegionId)
    {
        return erpDepositRegionMapper.deleteErpDepositRegionById(depositRegionId);
    }
}
