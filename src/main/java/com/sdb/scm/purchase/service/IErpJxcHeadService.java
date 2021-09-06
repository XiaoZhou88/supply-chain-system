package com.sdb.scm.purchase.service;

import java.util.List;
import com.sdb.scm.purchase.domain.ErpJxcHead;

/**
 * 采购订单Service接口
 * 
 * @author jzg
 * @date 2021-08-17
 */
public interface IErpJxcHeadService 
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
     * 批量删除采购订单
     * 
     * @param jxcHeadIds 需要删除的采购订单ID
     * @return 结果
     */
    public int deleteErpJxcHeadByIds(Long[] jxcHeadIds);

    /**
     * 删除采购订单信息
     * 
     * @param jxcHeadId 采购订单ID
     * @return 结果
     */
    public int deleteErpJxcHeadById(Long jxcHeadId);
}
