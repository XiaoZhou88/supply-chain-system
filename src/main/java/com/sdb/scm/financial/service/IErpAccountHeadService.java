package com.sdb.scm.financial.service;

import java.util.List;
import com.sdb.scm.financial.domain.ErpAccountHead;

/**
 * 收入单Service接口
 * 
 * @author sdb
 * @date 2021-08-16
 */
public interface IErpAccountHeadService 
{
    /**
     * 查询收入单
     * 
     * @param accountHeadId 收入单ID
     * @return 收入单
     */
    public ErpAccountHead selectErpAccountHeadById(Long accountHeadId);

    /**
     * 查询收入单列表
     * 
     * @param erpAccountHead 收入单
     * @return 收入单集合
     */
    public List<ErpAccountHead> selectErpAccountHeadList(ErpAccountHead erpAccountHead);

    /**
     * 新增收入单
     * 
     * @param erpAccountHead 收入单
     * @return 结果
     */
    public int insertErpAccountHead(ErpAccountHead erpAccountHead);

    /**
     * 修改收入单
     * 
     * @param erpAccountHead 收入单
     * @return 结果
     */
    public int updateErpAccountHead(ErpAccountHead erpAccountHead);

    /**
     * 批量删除收入单
     * 
     * @param accountHeadIds 需要删除的收入单ID
     * @return 结果
     */
    public int deleteErpAccountHeadByIds(Long[] accountHeadIds);

    /**
     * 删除收入单信息
     * 
     * @param accountHeadId 收入单ID
     * @return 结果
     */
    public int deleteErpAccountHeadById(Long accountHeadId);
}
