package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpDepositRegion;

/**
 * 库区设置Service接口
 * 
 * @author sdb
 * @date 2021-08-13
 */
public interface IErpDepositRegionService 
{
    /**
     * 查询库区设置
     * 
     * @param depositRegionId 库区设置ID
     * @return 库区设置
     */
    public ErpDepositRegion selectErpDepositRegionById(Long depositRegionId);

    /**
     * 查询库区设置列表
     * 
     * @param erpDepositRegion 库区设置
     * @return 库区设置集合
     */
    public List<ErpDepositRegion> selectErpDepositRegionList(ErpDepositRegion erpDepositRegion);

    /**
     * 新增库区设置
     * 
     * @param erpDepositRegion 库区设置
     * @return 结果
     */
    public int insertErpDepositRegion(ErpDepositRegion erpDepositRegion);

    /**
     * 修改库区设置
     * 
     * @param erpDepositRegion 库区设置
     * @return 结果
     */
    public int updateErpDepositRegion(ErpDepositRegion erpDepositRegion);

    /**
     * 批量删除库区设置
     * 
     * @param depositRegionIds 需要删除的库区设置ID
     * @return 结果
     */
    public int deleteErpDepositRegionByIds(Long[] depositRegionIds);

    /**
     * 删除库区设置信息
     * 
     * @param depositRegionId 库区设置ID
     * @return 结果
     */
    public int deleteErpDepositRegionById(Long depositRegionId);
}
