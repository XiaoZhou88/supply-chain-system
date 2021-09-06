package com.sdb.scm.financial.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 收入单对象 erp_account_head
 * 
 * @author sdb
 * @date 2021-08-16
 */
public class ErpAccountHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long accountHeadId;

    /** 类型(支出/收入/收款/付款/转账) */
    @Excel(name = "类型(支出/收入/收款/付款/转账)")
    private String type;

    /** 单位Id(收款/付款单位) */
    @Excel(name = "单位Id(收款/付款单位)")
    private Long organId;

    /** 经手人id */
    private Long agentId;

    /** 操作员 */
    private Long creator;

    /** 变动金额(优惠/收款/付款/实付) */
    @Excel(name = "变动金额(优惠/收款/付款/实付)")
    private BigDecimal changeAmount;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalPrice;

    /** 账户(收款/付款) */
    @Excel(name = "账户(收款/付款)")
    private Long accountId;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String billNo;

    /** 单据日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "单据日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date billTime;

    /** 附件名称 */
    private String fileName;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    /** 财务子信息 */
    private List<ErpAccountItem> erpAccountItemList;

    public void setAccountHeadId(Long accountHeadId) 
    {
        this.accountHeadId = accountHeadId;
    }

    public Long getAccountHeadId() 
    {
        return accountHeadId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setOrganId(Long organId) 
    {
        this.organId = organId;
    }

    public Long getOrganId() 
    {
        return organId;
    }
    public void setAgentId(Long agentId) 
    {
        this.agentId = agentId;
    }

    public Long getAgentId() 
    {
        return agentId;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setChangeAmount(BigDecimal changeAmount) 
    {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getChangeAmount() 
    {
        return changeAmount;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
    }
    public void setBillNo(String billNo) 
    {
        this.billNo = billNo;
    }

    public String getBillNo() 
    {
        return billNo;
    }
    public void setBillTime(Date billTime) 
    {
        this.billTime = billTime;
    }

    public Date getBillTime() 
    {
        return billTime;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
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

    public List<ErpAccountItem> getErpAccountItemList()
    {
        return erpAccountItemList;
    }

    public void setErpAccountItemList(List<ErpAccountItem> erpAccountItemList)
    {
        this.erpAccountItemList = erpAccountItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accountHeadId", getAccountHeadId())
            .append("type", getType())
            .append("organId", getOrganId())
            .append("agentId", getAgentId())
            .append("creator", getCreator())
            .append("changeAmount", getChangeAmount())
            .append("totalPrice", getTotalPrice())
            .append("accountId", getAccountId())
            .append("billNo", getBillNo())
            .append("billTime", getBillTime())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .append("erpAccountItemList", getErpAccountItemList())
            .toString();
    }
}
