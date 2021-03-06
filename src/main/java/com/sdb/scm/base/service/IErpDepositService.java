package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpDeposit;

/**
 * 仓库Service接口
 * 
 * @author sdb
 * @date 2021-08-11
 */
public interface IErpDepositService 
{
    /**
     * 查询仓库
     * 
     * @param depositId 仓库ID
     * @return 仓库
     */
    public ErpDeposit selectErpDepositById(Long depositId);

    /**
     * 查询仓库列表
     * 
     * @param erpDeposit 仓库
     * @return 仓库集合
     */
    public List<ErpDeposit> selectErpDepositList(ErpDeposit erpDeposit);

    /**
     * 新增仓库
     * 
     * @param erpDeposit 仓库
     * @return 结果
     */
    public int insertErpDeposit(ErpDeposit erpDeposit);

    /**
     * 修改仓库
     * 
     * @param erpDeposit 仓库
     * @return 结果
     */
    public int updateErpDeposit(ErpDeposit erpDeposit);

    /**
     * 批量删除仓库
     * 
     * @param depositIds 需要删除的仓库ID
     * @return 结果
     */
    public int deleteErpDepositByIds(Long[] depositIds);

    /**
     * 删除仓库信息
     * 
     * @param depositId 仓库ID
     * @return 结果
     */
    public int deleteErpDepositById(Long depositId);
}
