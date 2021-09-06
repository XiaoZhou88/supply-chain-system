package com.sdb.scm.financial.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.sdb.base.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.sdb.scm.financial.domain.ErpAccountItem;
import com.sdb.scm.financial.mapper.ErpAccountHeadMapper;
import com.sdb.scm.financial.domain.ErpAccountHead;
import com.sdb.scm.financial.service.IErpAccountHeadService;

/**
 * 收入单Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-16
 */
@Service
public class ErpAccountHeadServiceImpl implements IErpAccountHeadService 
{
    @Autowired
    private ErpAccountHeadMapper erpAccountHeadMapper;

    /**
     * 查询收入单
     * 
     * @param accountHeadId 收入单ID
     * @return 收入单
     */
    @Override
    public ErpAccountHead selectErpAccountHeadById(Long accountHeadId)
    {
        return erpAccountHeadMapper.selectErpAccountHeadById(accountHeadId);
    }

    /**
     * 查询收入单列表
     * 
     * @param erpAccountHead 收入单
     * @return 收入单
     */
    @Override
    public List<ErpAccountHead> selectErpAccountHeadList(ErpAccountHead erpAccountHead)
    {
        return erpAccountHeadMapper.selectErpAccountHeadList(erpAccountHead);
    }

    /**
     * 新增收入单
     * 
     * @param erpAccountHead 收入单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertErpAccountHead(ErpAccountHead erpAccountHead)
    {
        int rows = erpAccountHeadMapper.insertErpAccountHead(erpAccountHead);
        insertErpAccountItem(erpAccountHead);
        return rows;
    }

    /**
     * 修改收入单
     * 
     * @param erpAccountHead 收入单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateErpAccountHead(ErpAccountHead erpAccountHead)
    {
        erpAccountHeadMapper.deleteErpAccountItemByHeaderId(erpAccountHead.getAccountHeadId());
        insertErpAccountItem(erpAccountHead);
        return erpAccountHeadMapper.updateErpAccountHead(erpAccountHead);
    }

    /**
     * 批量删除收入单
     * 
     * @param accountHeadIds 需要删除的收入单ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteErpAccountHeadByIds(Long[] accountHeadIds)
    {
        erpAccountHeadMapper.deleteErpAccountItemByHeaderIds(accountHeadIds);
        return erpAccountHeadMapper.deleteErpAccountHeadByIds(accountHeadIds);
    }

    /**
     * 删除收入单信息
     * 
     * @param accountHeadId 收入单ID
     * @return 结果
     */
    @Override
    public int deleteErpAccountHeadById(Long accountHeadId)
    {
        erpAccountHeadMapper.deleteErpAccountItemByHeaderId(accountHeadId);
        return erpAccountHeadMapper.deleteErpAccountHeadById(accountHeadId);
    }

    /**
     * 新增财务子信息
     * 
     * @param erpAccountHead 收入单对象
     */
    public void insertErpAccountItem(ErpAccountHead erpAccountHead)
    {
        List<ErpAccountItem> erpAccountItemList = erpAccountHead.getErpAccountItemList();
        Long accountHeadId = erpAccountHead.getAccountHeadId();
        if (StringUtils.isNotNull(erpAccountItemList))
        {
            List<ErpAccountItem> list = new ArrayList<ErpAccountItem>();
            for (ErpAccountItem erpAccountItem : erpAccountItemList)
            {
                erpAccountItem.setHeaderId(accountHeadId);
                list.add(erpAccountItem);
            }
            if (list.size() > 0)
            {
                erpAccountHeadMapper.batchErpAccountItem(list);
            }
        }
    }
}
