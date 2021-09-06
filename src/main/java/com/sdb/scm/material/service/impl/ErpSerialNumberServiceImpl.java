package com.sdb.scm.material.service.impl;

import java.util.List;
import com.sdb.base.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.material.mapper.ErpSerialNumberMapper;
import com.sdb.scm.material.domain.ErpSerialNumber;
import com.sdb.scm.material.service.IErpSerialNumberService;

/**
 * 序列号Service业务层处理
 * 
 * @author jzg
 * @date 2021-08-14
 */
@Service
public class ErpSerialNumberServiceImpl implements IErpSerialNumberService 
{
    @Autowired
    private ErpSerialNumberMapper erpSerialNumberMapper;

    /**
     * 查询序列号
     * 
     * @param serialId 序列号ID
     * @return 序列号
     */
    @Override
    public ErpSerialNumber selectErpSerialNumberById(Long serialId)
    {
        return erpSerialNumberMapper.selectErpSerialNumberById(serialId);
    }

    /**
     * 查询序列号列表
     * 
     * @param erpSerialNumber 序列号
     * @return 序列号
     */
    @Override
    public List<ErpSerialNumber> selectErpSerialNumberList(ErpSerialNumber erpSerialNumber)
    {
        return erpSerialNumberMapper.selectErpSerialNumberList(erpSerialNumber);
    }

    /**
     * 新增序列号
     * 
     * @param erpSerialNumber 序列号
     * @return 结果
     */
    @Override
    public int insertErpSerialNumber(ErpSerialNumber erpSerialNumber)
    {
        erpSerialNumber.setCreateTime(DateUtils.getNowDate());
        return erpSerialNumberMapper.insertErpSerialNumber(erpSerialNumber);
    }

    /**
     * 修改序列号
     * 
     * @param erpSerialNumber 序列号
     * @return 结果
     */
    @Override
    public int updateErpSerialNumber(ErpSerialNumber erpSerialNumber)
    {
        erpSerialNumber.setUpdateTime(DateUtils.getNowDate());
        return erpSerialNumberMapper.updateErpSerialNumber(erpSerialNumber);
    }

    /**
     * 批量删除序列号
     * 
     * @param serialIds 需要删除的序列号ID
     * @return 结果
     */
    @Override
    public int deleteErpSerialNumberByIds(Long[] serialIds)
    {
        return erpSerialNumberMapper.deleteErpSerialNumberByIds(serialIds);
    }

    /**
     * 删除序列号信息
     * 
     * @param serialId 序列号ID
     * @return 结果
     */
    @Override
    public int deleteErpSerialNumberById(Long serialId)
    {
        return erpSerialNumberMapper.deleteErpSerialNumberById(serialId);
    }
}
