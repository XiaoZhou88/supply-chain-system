package com.sdb.scm.purchase.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 采购订单对象 erp_jxc_head
 * 
 * @author jzg
 * @date 2021-08-17
 */
public class ErpJxcHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long jxcHeadId;

    /** 类型(出库/入库) */
    @Excel(name = "类型(出库/入库)")
    private String type;

    /** 出入库分类 */
    @Excel(name = "出入库分类")
    private String subType;

    /** 初始票据号 */
    @Excel(name = "初始票据号")
    private String defaultNumber;

    /** 票据号 */
    @Excel(name = "票据号")
    private String number;

    /** 出入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operTime;

    /** 供应商id */
    @Excel(name = "供应商id")
    private Long organId;

    /** 采购/领料-经手人id */
    @Excel(name = "采购/领料-经手人id")
    private Long agentId;

    /** 操作员 */
    @Excel(name = "操作员")
    private Long creator;

    /** 账户id */
    @Excel(name = "账户id")
    private Long accountId;

    /** 变动金额(收款/付款) */
    @Excel(name = "变动金额(收款/付款)")
    private BigDecimal changeAmount;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private BigDecimal totalPrice;

    /** 付款类型(现金、记账等) */
    @Excel(name = "付款类型(现金、记账等)")
    private String payType;

    /** 单据类型 */
    @Excel(name = "单据类型")
    private String billType;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String fileName;

    /** 业务员（可以多个） */
    @Excel(name = "业务员", readConverterExp = "可=以多个")
    private String salesMan;

    /** 多账户ID列表 */
    @Excel(name = "多账户ID列表")
    private String accountIdList;

    /** 多账户金额列表 */
    @Excel(name = "多账户金额列表")
    private String accountMoneyList;

    /** 优惠率 */
    @Excel(name = "优惠率")
    private BigDecimal discount;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private BigDecimal discountMoney;

    /** 优惠后金额 */
    @Excel(name = "优惠后金额")
    private BigDecimal discountLastMoney;

    /** 销售或采购费用合计 */
    @Excel(name = "销售或采购费用合计")
    private BigDecimal otherMoney;

    /** 销售或采购费用涉及项目Id数组（包括快递、招待等） */
    @Excel(name = "销售或采购费用涉及项目Id数组", readConverterExp = "包=括快递、招待等")
    private String otherMoneyList;

    /** 销售或采购费用涉及项目（包括快递、招待等） */
    @Excel(name = "销售或采购费用涉及项目", readConverterExp = "包=括快递、招待等")
    private String otherMoneyItem;

    /** 结算天数 */
    @Excel(name = "结算天数")
    private Integer accountDay;

    /** 状态，0未审核、1已审核、2已转采购|销售 */
    @Excel(name = "状态，0未审核、1已审核、2已转采购|销售")
    private String status;

    /** 关联订单号 */
    @Excel(name = "关联订单号")
    private String linkNumber;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    /** 进销存单据子信息 */
    private List<ErpJxcItem> erpJxcItemList;

    public void setJxcHeadId(Long jxcHeadId) 
    {
        this.jxcHeadId = jxcHeadId;
    }

    public Long getJxcHeadId() 
    {
        return jxcHeadId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSubType(String subType) 
    {
        this.subType = subType;
    }

    public String getSubType() 
    {
        return subType;
    }
    public void setDefaultNumber(String defaultNumber) 
    {
        this.defaultNumber = defaultNumber;
    }

    public String getDefaultNumber() 
    {
        return defaultNumber;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setOperTime(Date operTime) 
    {
        this.operTime = operTime;
    }

    public Date getOperTime() 
    {
        return operTime;
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
    public void setAccountId(Long accountId) 
    {
        this.accountId = accountId;
    }

    public Long getAccountId() 
    {
        return accountId;
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
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setBillType(String billType) 
    {
        this.billType = billType;
    }

    public String getBillType() 
    {
        return billType;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setSalesMan(String salesMan) 
    {
        this.salesMan = salesMan;
    }

    public String getSalesMan() 
    {
        return salesMan;
    }
    public void setAccountIdList(String accountIdList) 
    {
        this.accountIdList = accountIdList;
    }

    public String getAccountIdList() 
    {
        return accountIdList;
    }
    public void setAccountMoneyList(String accountMoneyList) 
    {
        this.accountMoneyList = accountMoneyList;
    }

    public String getAccountMoneyList() 
    {
        return accountMoneyList;
    }
    public void setDiscount(BigDecimal discount) 
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount() 
    {
        return discount;
    }
    public void setDiscountMoney(BigDecimal discountMoney) 
    {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountMoney() 
    {
        return discountMoney;
    }
    public void setDiscountLastMoney(BigDecimal discountLastMoney) 
    {
        this.discountLastMoney = discountLastMoney;
    }

    public BigDecimal getDiscountLastMoney() 
    {
        return discountLastMoney;
    }
    public void setOtherMoney(BigDecimal otherMoney) 
    {
        this.otherMoney = otherMoney;
    }

    public BigDecimal getOtherMoney() 
    {
        return otherMoney;
    }
    public void setOtherMoneyList(String otherMoneyList) 
    {
        this.otherMoneyList = otherMoneyList;
    }

    public String getOtherMoneyList() 
    {
        return otherMoneyList;
    }
    public void setOtherMoneyItem(String otherMoneyItem) 
    {
        this.otherMoneyItem = otherMoneyItem;
    }

    public String getOtherMoneyItem() 
    {
        return otherMoneyItem;
    }
    public void setAccountDay(Integer accountDay) 
    {
        this.accountDay = accountDay;
    }

    public Integer getAccountDay() 
    {
        return accountDay;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setLinkNumber(String linkNumber) 
    {
        this.linkNumber = linkNumber;
    }

    public String getLinkNumber() 
    {
        return linkNumber;
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

    public List<ErpJxcItem> getErpJxcItemList()
    {
        return erpJxcItemList;
    }

    public void setErpJxcItemList(List<ErpJxcItem> erpJxcItemList)
    {
        this.erpJxcItemList = erpJxcItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jxcHeadId", getJxcHeadId())
            .append("type", getType())
            .append("subType", getSubType())
            .append("defaultNumber", getDefaultNumber())
            .append("number", getNumber())
            .append("createTime", getCreateTime())
            .append("operTime", getOperTime())
            .append("organId", getOrganId())
            .append("agentId", getAgentId())
            .append("creator", getCreator())
            .append("accountId", getAccountId())
            .append("changeAmount", getChangeAmount())
            .append("totalPrice", getTotalPrice())
            .append("payType", getPayType())
            .append("billType", getBillType())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("salesMan", getSalesMan())
            .append("accountIdList", getAccountIdList())
            .append("accountMoneyList", getAccountMoneyList())
            .append("discount", getDiscount())
            .append("discountMoney", getDiscountMoney())
            .append("discountLastMoney", getDiscountLastMoney())
            .append("otherMoney", getOtherMoney())
            .append("otherMoneyList", getOtherMoneyList())
            .append("otherMoneyItem", getOtherMoneyItem())
            .append("accountDay", getAccountDay())
            .append("status", getStatus())
            .append("linkNumber", getLinkNumber())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .append("erpJxcItemList", getErpJxcItemList())
            .toString();
    }
}
