package com.sdb.scm.base.domain;

import java.math.BigDecimal;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 账户信息对象 erp_account
 * 
 * @author sdb
 * @date 2021-08-14
 */
public class ErpAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long accountId;

    /** 名称 */
    @Excel(name = "名称")
    private String accountName;

    /** 编号 */
    @Excel(name = "编号")
    private String serialNo;

    /** 期初金额 */
    @Excel(name = "期初金额")
    private BigDecimal initialAmount;

    /** 当前余额 */
    @Excel(name = "当前余额")
    private BigDecimal currentAmount;

    /** 是否默认 */
    private Integer isDefault;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
    }
    public void setAccountName(String accountName) 
    {
        this.accountName = accountName;
    }

    public String getAccountName() 
    {
        return accountName;
    }
    public void setSerialNo(String serialNo) 
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo() 
    {
        return serialNo;
    }
    public void setInitialAmount(BigDecimal initialAmount) 
    {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getInitialAmount() 
    {
        return initialAmount;
    }
    public void setCurrentAmount(BigDecimal currentAmount) 
    {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getCurrentAmount() 
    {
        return currentAmount;
    }
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("accountId", getAccountId())
            .append("accountName", getAccountName())
            .append("serialNo", getSerialNo())
            .append("initialAmount", getInitialAmount())
            .append("currentAmount", getCurrentAmount())
            .append("remark", getRemark())
            .append("isDefault", getIsDefault())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
