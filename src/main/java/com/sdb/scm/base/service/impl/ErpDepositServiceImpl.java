package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpDepositMapper;
import com.sdb.scm.base.domain.ErpDeposit;
import com.sdb.scm.base.service.IErpDepositService;

/**
 * 仓库Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-11
 */
@Service
public class ErpDepositServiceImpl implements IErpDepositService 
{
    @Autowired
    private ErpDepositMapper erpDepositMapper;

    /**
     * 查询仓库
     * 
     * @param depositId 仓库ID
     * @return 仓库
     */
    @Override
    public ErpDeposit selectErpDepositById(Long depositId)
    {
        return erpDepositMapper.selectErpDepositById(depositId);
    }

    /**
     * 查询仓库列表
     * 
     * @param erpDeposit 仓库
     * @return 仓库
     */
    @Override
    public List<ErpDeposit> selectErpDepositList(ErpDeposit erpDeposit)
    {
        return erpDepositMapper.selectErpDepositList(erpDeposit);
    }

    /**
     * 新增仓库
     * 
     * @param erpDeposit 仓库
     * @return 结果
     */
    @Override
    public int insertErpDeposit(ErpDeposit erpDeposit)
    {
        return erpDepositMapper.insertErpDeposit(erpDeposit);
    }

    /**
     * 修改仓库
     * 
     * @param erpDeposit 仓库
     * @return 结果
     */
    @Override
    public int updateErpDeposit(ErpDeposit erpDeposit)
    {
        return erpDepositMapper.updateErpDeposit(erpDeposit);
    }

    /**
     * 批量删除仓库
     * 
     * @param depositIds 需要删除的仓库ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositByIds(Long[] depositIds)
    {
        return erpDepositMapper.deleteErpDepositByIds(depositIds);
    }

    /**
     * 删除仓库信息
     * 
     * @param depositId 仓库ID
     * @return 结果
     */
    @Override
    public int deleteErpDepositById(Long depositId)
    {
        return erpDepositMapper.deleteErpDepositById(depositId);
    }
}
