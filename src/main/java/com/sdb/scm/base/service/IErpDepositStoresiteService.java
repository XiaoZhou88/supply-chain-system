package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpDepositStoresite;

/**
 * 库位设置Service接口
 * 
 * @author sdb
 * @date 2021-08-09
 */
public interface IErpDepositStoresiteService 
{
    /**
     * 查询库位设置
     * 
     * @param depositStoresiteId 库位设置ID
     * @return 库位设置
     */
    public ErpDepositStoresite selectErpDepositStoresiteById(Long depositStoresiteId);

    /**
     * 查询库位设置列表
     * 
     * @param erpDepositStoresite 库位设置
     * @return 库位设置集合
     */
    public List<ErpDepositStoresite> selectErpDepositStoresiteList(ErpDepositStoresite erpDepositStoresite);

    /**
     * 新增库位设置
     * 
     * @param erpDepositStoresite 库位设置
     * @return 结果
     */
    public int insertErpDepositStoresite(ErpDepositStoresite erpDepositStoresite);

    /**
     * 修改库位设置
     * 
     * @param erpDepositStoresite 库位设置
     * @return 结果
     */
    public int updateErpDepositStoresite(ErpDepositStoresite erpDepositStoresite);

    /**
     * 批量删除库位设置
     * 
     * @param depositStoresiteIds 需要删除的库位设置ID
     * @return 结果
     */
    public int deleteErpDepositStoresiteByIds(Long[] depositStoresiteIds);

    /**
     * 删除库位设置信息
     * 
     * @param depositStoresiteId 库位设置ID
     * @return 结果
     */
    public int deleteErpDepositStoresiteById(Long depositStoresiteId);
}
