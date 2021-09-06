package com.sdb.scm.base.mapper;

import java.util.List;
import com.sdb.scm.base.domain.ErpAccount;

/**
 * 账户信息Mapper接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface ErpAccountMapper 
{
    /**
     * 查询账户信息
     * 
     * @param accountId 账户信息ID
     * @return 账户信息
     */
    public ErpAccount selectErpAccountById(Long accountId);

    /**
     * 查询账户信息列表
     * 
     * @param erpAccount 账户信息
     * @return 账户信息集合
     */
    public List<ErpAccount> selectErpAccountList(ErpAccount erpAccount);

    /**
     * 新增账户信息
     * 
     * @param erpAccount 账户信息
     * @return 结果
     */
    public int insertErpAccount(ErpAccount erpAccount);

    /**
     * 修改账户信息
     * 
     * @param erpAccount 账户信息
     * @return 结果
     */
    public int updateErpAccount(ErpAccount erpAccount);

    /**
     * 删除账户信息
     * 
     * @param accountId 账户信息ID
     * @return 结果
     */
    public int deleteErpAccountById(Long accountId);

    /**
     * 批量删除账户信息
     * 
     * @param accountIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpAccountByIds(Long[] accountIds);
}
