package com.sdb.scm.purchase.mapper;

import java.util.List;
import com.sdb.scm.purchase.domain.ErpJxcHead;
import com.sdb.scm.purchase.domain.ErpJxcItem;

/**
 * 采购订单Mapper接口
 * 
 * @author jzg
 * @date 2021-08-17
 */
public interface ErpJxcHeadMapper 
{
    /**
     * 查询采购订单
     * 
     * @param jxcHeadId 采购订单ID
     * @return 采购订单
     */
    public ErpJxcHead selectErpJxcHeadById(Long jxcHeadId);

    /**
     * 查询采购订单列表
     * 
     * @param erpJxcHead 采购订单
     * @return 采购订单集合
     */
    public List<ErpJxcHead> selectErpJxcHeadList(ErpJxcHead erpJxcHead);

    /**
     * 新增采购订单
     * 
     * @param erpJxcHead 采购订单
     * @return 结果
     */
    public int insertErpJxcHead(ErpJxcHead erpJxcHead);

    /**
     * 修改采购订单
     * 
     * @param erpJxcHead 采购订单
     * @return 结果
     */
    public int updateErpJxcHead(ErpJxcHead erpJxcHead);

    /**
     * 删除采购订单
     * 
     * @param jxcHeadId 采购订单ID
     * @return 结果
     */
    public int deleteErpJxcHeadById(Long jxcHeadId);

    /**
     * 批量删除采购订单
     * 
     * @param jxcHeadIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpJxcHeadByIds(Long[] jxcHeadIds);

    /**
     * 批量删除进销存单据子
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpJxcItemByHeaderIds(Long[] jxcHeadIds);
    
    /**
     * 批量新增进销存单据子
     * 
     * @param erpJxcItemList 进销存单据子列表
     * @return 结果
     */
    public int batchErpJxcItem(List<ErpJxcItem> erpJxcItemList);
    

    /**
     * 通过采购订单ID删除进销存单据子信息
     * 
     * @param jxcHeadId 采购订单ID
     * @return 结果
     */
    public int deleteErpJxcItemByHeaderId(Long jxcHeadId);
}
