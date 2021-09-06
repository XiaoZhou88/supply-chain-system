package com.sdb.scm.material.service;

import java.util.List;
import com.sdb.scm.material.domain.ErpSerialNumber;

/**
 * 序列号Service接口
 * 
 * @author jzg
 * @date 2021-08-14
 */
public interface IErpSerialNumberService 
{
    /**
     * 查询序列号
     * 
     * @param serialId 序列号ID
     * @return 序列号
     */
    public ErpSerialNumber selectErpSerialNumberById(Long serialId);

    /**
     * 查询序列号列表
     * 
     * @param erpSerialNumber 序列号
     * @return 序列号集合
     */
    public List<ErpSerialNumber> selectErpSerialNumberList(ErpSerialNumber erpSerialNumber);

    /**
     * 新增序列号
     * 
     * @param erpSerialNumber 序列号
     * @return 结果
     */
    public int insertErpSerialNumber(ErpSerialNumber erpSerialNumber);

    /**
     * 修改序列号
     * 
     * @param erpSerialNumber 序列号
     * @return 结果
     */
    public int updateErpSerialNumber(ErpSerialNumber erpSerialNumber);

    /**
     * 批量删除序列号
     * 
     * @param serialIds 需要删除的序列号ID
     * @return 结果
     */
    public int deleteErpSerialNumberByIds(Long[] serialIds);

    /**
     * 删除序列号信息
     * 
     * @param serialId 序列号ID
     * @return 结果
     */
    public int deleteErpSerialNumberById(Long serialId);
}
