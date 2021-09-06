package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpBillNoMapper;
import com.sdb.scm.base.domain.ErpBillNo;
import com.sdb.scm.base.service.IErpBillNoService;

/**
 * 单据编号Service业务层处理
 * 
 * @author jzg
 * @date 2021-08-18
 */
@Service
public class ErpBillNoServiceImpl implements IErpBillNoService 
{
    @Autowired
    private ErpBillNoMapper erpBillNoMapper;

    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号ID
     * @return 单据编号
     */
    @Override
    public ErpBillNo selectErpBillNoById(String seqName)
    {
        return erpBillNoMapper.selectErpBillNoById(seqName);
    }

    /**
     * 查询单据编号列表
     * 
     * @param erpBillNo 单据编号
     * @return 单据编号
     */
    @Override
    public List<ErpBillNo> selectErpBillNoList(ErpBillNo erpBillNo)
    {
        return erpBillNoMapper.selectErpBillNoList(erpBillNo);
    }

    /**
     * 新增单据编号
     * 
     * @param erpBillNo 单据编号
     * @return 结果
     */
    @Override
    public int insertErpBillNo(ErpBillNo erpBillNo)
    {
        return erpBillNoMapper.insertErpBillNo(erpBillNo);
    }

    /**
     * 修改单据编号
     * 
     * @param erpBillNo 单据编号
     * @return 结果
     */
    @Override
    public int updateErpBillNo(ErpBillNo erpBillNo)
    {
        ErpBillNo billNo = selectErpBillNoById("bill_number_seq");
        billNo.setCurrentVal(billNo.getCurrentVal()+1);
        return erpBillNoMapper.updateErpBillNo(billNo);
    }

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的单据编号ID
     * @return 结果
     */
    @Override
    public int deleteErpBillNoByIds(String[] seqNames)
    {
        return erpBillNoMapper.deleteErpBillNoByIds(seqNames);
    }

    /**
     * 删除单据编号信息
     * 
     * @param seqName 单据编号ID
     * @return 结果
     */
    @Override
    public int deleteErpBillNoById(String seqName)
    {
        return erpBillNoMapper.deleteErpBillNoById(seqName);
    }
}
