package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpIoitemMapper;
import com.sdb.scm.base.domain.ErpIoitem;
import com.sdb.scm.base.service.IErpIoitemService;

/**
 * 收支项目Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-14
 */
@Service
public class ErpIoitemServiceImpl implements IErpIoitemService 
{
    @Autowired
    private ErpIoitemMapper erpIoitemMapper;

    /**
     * 查询收支项目
     * 
     * @param ioitemId 收支项目ID
     * @return 收支项目
     */
    @Override
    public ErpIoitem selectErpIoitemById(Long ioitemId)
    {
        return erpIoitemMapper.selectErpIoitemById(ioitemId);
    }

    /**
     * 查询收支项目列表
     * 
     * @param erpIoitem 收支项目
     * @return 收支项目
     */
    @Override
    public List<ErpIoitem> selectErpIoitemList(ErpIoitem erpIoitem)
    {
        return erpIoitemMapper.selectErpIoitemList(erpIoitem);
    }

    /**
     * 新增收支项目
     * 
     * @param erpIoitem 收支项目
     * @return 结果
     */
    @Override
    public int insertErpIoitem(ErpIoitem erpIoitem)
    {
        return erpIoitemMapper.insertErpIoitem(erpIoitem);
    }

    /**
     * 修改收支项目
     * 
     * @param erpIoitem 收支项目
     * @return 结果
     */
    @Override
    public int updateErpIoitem(ErpIoitem erpIoitem)
    {
        return erpIoitemMapper.updateErpIoitem(erpIoitem);
    }

    /**
     * 批量删除收支项目
     * 
     * @param ioitemIds 需要删除的收支项目ID
     * @return 结果
     */
    @Override
    public int deleteErpIoitemByIds(Long[] ioitemIds)
    {
        return erpIoitemMapper.deleteErpIoitemByIds(ioitemIds);
    }

    /**
     * 删除收支项目信息
     * 
     * @param ioitemId 收支项目ID
     * @return 结果
     */
    @Override
    public int deleteErpIoitemById(Long ioitemId)
    {
        return erpIoitemMapper.deleteErpIoitemById(ioitemId);
    }
}
