package com.sdb.scm.financial.mapper;

import java.util.List;
import com.sdb.scm.financial.domain.ErpAccountHead;
import com.sdb.scm.financial.domain.ErpAccountItem;

/**
 * 收入单Mapper接口
 * 
 * @author sdb
 * @date 2021-08-16
 */
public interface ErpAccountHeadMapper 
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
     * 删除收入单
     * 
     * @param accountHeadId 收入单ID
     * @return 结果
     */
    public int deleteErpAccountHeadById(Long accountHeadId);

    /**
     * 批量删除收入单
     * 
     * @param accountHeadIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpAccountHeadByIds(Long[] accountHeadIds);

    /**
     * 批量删除财务子
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpAccountItemByHeaderIds(Long[] accountHeadIds);
    
    /**
     * 批量新增财务子
     * 
     * @param erpAccountItemList 财务子列表
     * @return 结果
     */
    public int batchErpAccountItem(List<ErpAccountItem> erpAccountItemList);
    

    /**
     * 通过收入单ID删除财务子信息
     * 
     * @param accountHeadId 收入单ID
     * @return 结果
     */
    public int deleteErpAccountItemByHeaderId(Long accountHeadId);
}
