package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpBillNo;

/**
 * 单据编号Service接口
 * 
 * @author jzg
 * @date 2021-08-18
 */
public interface IErpBillNoService 
{
    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号ID
     * @return 单据编号
     */
    public ErpBillNo selectErpBillNoById(String seqName);

    /**
     * 查询单据编号列表
     * 
     * @param erpBillNo 单据编号
     * @return 单据编号集合
     */
    public List<ErpBillNo> selectErpBillNoList(ErpBillNo erpBillNo);

    /**
     * 新增单据编号
     * 
     * @param erpBillNo 单据编号
     * @return 结果
     */
    public int insertErpBillNo(ErpBillNo erpBillNo);

    /**
     * 修改单据编号
     * 
     * @param erpBillNo 单据编号
     * @return 结果
     */
    public int updateErpBillNo(ErpBillNo erpBillNo);

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的单据编号ID
     * @return 结果
     */
    public int deleteErpBillNoByIds(String[] seqNames);

    /**
     * 删除单据编号信息
     * 
     * @param seqName 单据编号ID
     * @return 结果
     */
    public int deleteErpBillNoById(String seqName);
}
