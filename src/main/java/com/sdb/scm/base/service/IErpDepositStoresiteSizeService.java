package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpDepositStoresiteSize;

/**
 * 库位尺寸Service接口
 * 
 * @author sdb
 * @date 2021-08-13
 */
public interface IErpDepositStoresiteSizeService 
{
    /**
     * 查询库位尺寸
     * 
     * @param storesizeId 库位尺寸ID
     * @return 库位尺寸
     */
    public ErpDepositStoresiteSize selectErpDepositStoresiteSizeById(Long storesizeId);

    /**
     * 查询库位尺寸列表
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 库位尺寸集合
     */
    public List<ErpDepositStoresiteSize> selectErpDepositStoresiteSizeList(ErpDepositStoresiteSize erpDepositStoresiteSize);

    /**
     * 新增库位尺寸
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 结果
     */
    public int insertErpDepositStoresiteSize(ErpDepositStoresiteSize erpDepositStoresiteSize);

    /**
     * 修改库位尺寸
     * 
     * @param erpDepositStoresiteSize 库位尺寸
     * @return 结果
     */
    public int updateErpDepositStoresiteSize(ErpDepositStoresiteSize erpDepositStoresiteSize);

    /**
     * 批量删除库位尺寸
     * 
     * @param storesizeIds 需要删除的库位尺寸ID
     * @return 结果
     */
    public int deleteErpDepositStoresiteSizeByIds(Long[] storesizeIds);

    /**
     * 删除库位尺寸信息
     * 
     * @param storesizeId 库位尺寸ID
     * @return 结果
     */
    public int deleteErpDepositStoresiteSizeById(Long storesizeId);
}
