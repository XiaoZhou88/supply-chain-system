package com.sdb.scm.purchase.service.impl;

import java.util.List;
import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.sdb.base.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.sdb.scm.purchase.domain.ErpJxcItem;
import com.sdb.scm.purchase.mapper.ErpJxcHeadMapper;
import com.sdb.scm.purchase.domain.ErpJxcHead;
import com.sdb.scm.purchase.service.IErpJxcHeadService;

/**
 * 采购订单Service业务层处理
 * 
 * @author jzg
 * @date 2021-08-17
 */
@Service
public class ErpJxcHeadServiceImpl implements IErpJxcHeadService 
{
    @Autowired
    private ErpJxcHeadMapper erpJxcHeadMapper;

    /**
     * 查询采购订单
     * 
     * @param jxcHeadId 采购订单ID
     * @return 采购订单
     */
    @Override
    public ErpJxcHead selectErpJxcHeadById(Long jxcHeadId)
    {
        return erpJxcHeadMapper.selectErpJxcHeadById(jxcHeadId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param erpJxcHead 采购订单
     * @return 采购订单
     */
    @Override
    public List<ErpJxcHead> selectErpJxcHeadList(ErpJxcHead erpJxcHead)
    {
        return erpJxcHeadMapper.selectErpJxcHeadList(erpJxcHead);
    }

    /**
     * 新增采购订单
     * 
     * @param erpJxcHead 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertErpJxcHead(ErpJxcHead erpJxcHead)
    {
        erpJxcHead.setCreateTime(DateUtils.getNowDate());
        int rows = erpJxcHeadMapper.insertErpJxcHead(erpJxcHead);
        insertErpJxcItem(erpJxcHead);
        return rows;
    }

    /**
     * 修改采购订单
     * 
     * @param erpJxcHead 采购订单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateErpJxcHead(ErpJxcHead erpJxcHead)
    {
        erpJxcHeadMapper.deleteErpJxcItemByHeaderId(erpJxcHead.getJxcHeadId());
        insertErpJxcItem(erpJxcHead);
        return erpJxcHeadMapper.updateErpJxcHead(erpJxcHead);
    }

    /**
     * 批量删除采购订单
     * 
     * @param jxcHeadIds 需要删除的采购订单ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteErpJxcHeadByIds(Long[] jxcHeadIds)
    {
        erpJxcHeadMapper.deleteErpJxcItemByHeaderIds(jxcHeadIds);
        return erpJxcHeadMapper.deleteErpJxcHeadByIds(jxcHeadIds);
    }

    /**
     * 删除采购订单信息
     * 
     * @param jxcHeadId 采购订单ID
     * @return 结果
     */
    @Override
    public int deleteErpJxcHeadById(Long jxcHeadId)
    {
        erpJxcHeadMapper.deleteErpJxcItemByHeaderId(jxcHeadId);
        return erpJxcHeadMapper.deleteErpJxcHeadById(jxcHeadId);
    }

    /**
     * 新增进销存单据子信息
     * 
     * @param erpJxcHead 采购订单对象
     */
    public void insertErpJxcItem(ErpJxcHead erpJxcHead)
    {
        List<ErpJxcItem> erpJxcItemList = erpJxcHead.getErpJxcItemList();
        Long jxcHeadId = erpJxcHead.getJxcHeadId();
        if (StringUtils.isNotNull(erpJxcItemList))
        {
            List<ErpJxcItem> list = new ArrayList<ErpJxcItem>();
            for (ErpJxcItem erpJxcItem : erpJxcItemList)
            {
                erpJxcItem.setHeaderId(jxcHeadId);
                list.add(erpJxcItem);
            }
            if (list.size() > 0)
            {
                erpJxcHeadMapper.batchErpJxcItem(list);
            }
        }
    }
}
