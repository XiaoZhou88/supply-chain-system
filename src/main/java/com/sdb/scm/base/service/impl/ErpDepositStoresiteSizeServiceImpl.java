package com.sdb.scm.base.service.impl;

import java.util.List;
import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpDepositStoresiteSizeMapper;
import com.sdb.scm.base.domain.ErpDepositStoresiteSize;
import com.sdb.scm.base.service.IErpDepositStoresiteSizeService;

/**
 * 库位尺寸Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-13
 */
@Service
public class ErpDepositStoresiteSizeServiceImpl implements IErpDepositStoresiteSizeService 
{
    @Autowired
    private ErpDepositStoresiteSizeMapper erpDepositStoresiteSizeMapper;

    /**
     * 查询库位尺寸
     * 
     * @param storesizeId 库位尺寸ID
     * @return 库位尺寸
     */
    @Override
    public ErpDepositStoresiteSize selectErpDepositStoresiteSizeById(Long storesizeId)
    {
        return erpDepositStoresiteSizeMapper.selectErpDepositStoresiteSizeById(storesizeId);
    }

    /**
     * 查询库位尺寸列表
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 库位尺寸
     */
    @Override
    public List<ErpDepositStoresiteSize> selectErpDepositStoresiteSizeList(ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        return erpDepositStoresiteSizeMapper.selectErpDepositStoresiteSizeList(erpDepositStoresiteSize);
    }

    /**
     * 新增库位尺寸
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 结果
     */
    @Override
    public int insertErpDepositStoresiteSize(ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        erpDepositStoresiteSize.setCreateTime(DateUtils.getNowDate());
        return erpDepositStoresiteSizeMapper.insertErpDepositStoresiteSize(erpDepositStoresiteSize);
    }

    /**
     * 修改库位尺寸
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 结果
     */
    @Override
    public int updateErpDepositStoresiteSize(ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        erpDepositStoresiteSize.setUpdateTime(DateUtils.getNowDate());
        return erpDepositStoresiteSizeMapper.updateErpDepositStoresiteSize(erpDepositStoresiteSize);
    }

    /**
     * 批量删除库位尺寸
     * 
     * @param storesizeIds 需要删除的库位尺寸ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositStoresiteSizeByIds(Long[] storesizeIds)
    {
        return erpDepositStoresiteSizeMapper.deleteErpDepositStoresiteSizeByIds(storesizeIds);
    }

    /**
     * 删除库位尺寸信息
     * 
     * @param storesizeId 库位尺寸ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositStoresiteSizeById(Long storesizeId)
    {
        return erpDepositStoresiteSizeMapper.deleteErpDepositStoresiteSizeById(storesizeId);
    }
}
