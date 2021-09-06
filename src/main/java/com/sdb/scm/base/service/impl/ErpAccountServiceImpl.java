package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpAccountMapper;
import com.sdb.scm.base.domain.ErpAccount;
import com.sdb.scm.base.service.IErpAccountService;

/**
 * 账户信息Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-14
 */
@Service
public class ErpAccountServiceImpl implements IErpAccountService 
{
    @Autowired
    private ErpAccountMapper erpAccountMapper;

    /**
     * 查询账户信息
     * 
     * @param accountId 账户信息ID
     * @return 账户信息
     */
    @Override
    public ErpAccount selectErpAccountById(Long accountId)
    {
        return erpAccountMapper.selectErpAccountById(accountId);
    }

    /**
     * 查询账户信息列表
     * 
     * @param erpAccount 账户信息
     * @return 账户信息
     */
    @Override
    public List<ErpAccount> selectErpAccountList(ErpAccount erpAccount)
    {
        return erpAccountMapper.selectErpAccountList(erpAccount);
    }

    /**
     * 新增账户信息
     * 
     * @param erpAccount 账户信息
     * @return 结果
     */
    @Override
    public int insertErpAccount(ErpAccount erpAccount)
    {
        return erpAccountMapper.insertErpAccount(erpAccount);
    }

    /**
     * 修改账户信息
     * 
     * @param erpAccount 账户信息
     * @return 结果
     */
    @Override
    public int updateErpAccount(ErpAccount erpAccount)
    {
        return erpAccountMapper.updateErpAccount(erpAccount);
    }

    /**
     * 批量删除账户信息
     * 
     * @param accountIds 需要删除的账户信息ID
     * @return 结果
     */
    @Override
    public int deleteErpAccountByIds(Long[] accountIds)
    {
        return erpAccountMapper.deleteErpAccountByIds(accountIds);
    }

    /**
     * 删除账户信息信息
     * 
     * @param accountId 账户信息ID
     * @return 结果
     */
    @Override
    public int deleteErpAccountById(Long accountId)
    {
        return erpAccountMapper.deleteErpAccountById(accountId);
    }
}
