package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpIoitem;

/**
 * 收支项目Service接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface IErpIoitemService 
{
    /**
     * 查询收支项目
     * 
     * @param ioitemId 收支项目ID
     * @return 收支项目
     */
    public ErpIoitem selectErpIoitemById(Long ioitemId);

    /**
     * 查询收支项目列表
     * 
     * @param erpIoitem 收支项目
     * @return 收支项目集合
     */
    public List<ErpIoitem> selectErpIoitemList(ErpIoitem erpIoitem);

    /**
     * 新增收支项目
     * 
     * @param erpIoitem 收支项目
     * @return 结果
     */
    public int insertErpIoitem(ErpIoitem erpIoitem);

    /**
     * 修改收支项目
     * 
     * @param erpIoitem 收支项目
     * @return 结果
     */
    public int updateErpIoitem(ErpIoitem erpIoitem);

    /**
     * 批量删除收支项目
     * 
     * @param ioitemIds 需要删除的收支项目ID
     * @return 结果
     */
    public int deleteErpIoitemByIds(Long[] ioitemIds);

    /**
     * 删除收支项目信息
     * 
     * @param ioitemId 收支项目ID
     * @return 结果
     */
    public int deleteErpIoitemById(Long ioitemId);
}
