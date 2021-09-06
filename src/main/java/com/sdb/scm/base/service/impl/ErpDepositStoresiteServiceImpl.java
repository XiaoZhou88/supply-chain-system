package com.sdb.scm.base.service.impl;

import java.util.List;
import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpDepositStoresiteMapper;
import com.sdb.scm.base.domain.ErpDepositStoresite;
import com.sdb.scm.base.service.IErpDepositStoresiteService;

/**
 * 库位设置Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-09
 */
@Service
public class ErpDepositStoresiteServiceImpl implements IErpDepositStoresiteService 
{
    @Autowired
    private ErpDepositStoresiteMapper erpDepositStoresiteMapper;

    /**
     * 查询库位设置
     * 
     * @param depositStoresiteId 库位设置ID
     * @return 库位设置
     */
    @Override
    public ErpDepositStoresite selectErpDepositStoresiteById(Long depositStoresiteId)
    {
        return erpDepositStoresiteMapper.selectErpDepositStoresiteById(depositStoresiteId);
    }

    /**
     * 查询库位设置列表
     * 
     * @param erpDepositStoresite 库位设置
     * @return 库位设置
     */
    @Override
    public List<ErpDepositStoresite> selectErpDepositStoresiteList(ErpDepositStoresite erpDepositStoresite)
    {
        return erpDepositStoresiteMapper.selectErpDepositStoresiteList(erpDepositStoresite);
    }

    /**
     * 新增库位设置
     * 
     * @param erpDepositStoresite 库位设置
     * @return 结果
     */
    @Override
    public int insertErpDepositStoresite(ErpDepositStoresite erpDepositStoresite)
    {
        erpDepositStoresite.setCreateTime(DateUtils.getNowDate());
        return erpDepositStoresiteMapper.insertErpDepositStoresite(erpDepositStoresite);
    }

    /**
     * 修改库位设置
     * 
     * @param erpDepositStoresite 库位设置
     * @return 结果
     */
    @Override
    public int updateErpDepositStoresite(ErpDepositStoresite erpDepositStoresite)
    {
        erpDepositStoresite.setUpdateTime(DateUtils.getNowDate());
        return erpDepositStoresiteMapper.updateErpDepositStoresite(erpDepositStoresite);
    }

    /**
     * 批量删除库位设置
     * 
     * @param depositStoresiteIds 需要删除的库位设置ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositStoresiteByIds(Long[] depositStoresiteIds)
    {
        return erpDepositStoresiteMapper.deleteErpDepositStoresiteByIds(depositStoresiteIds);
    }

    /**
     * 删除库位设置信息
     * 
     * @param depositStoresiteId 库位设置ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositStoresiteById(Long depositStoresiteId)
    {
        return erpDepositStoresiteMapper.deleteErpDepositStoresiteById(depositStoresiteId);
    }
}
