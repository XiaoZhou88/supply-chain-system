package com.sdb.scm.base.domain;

import java.math.BigDecimal;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 供应商信息对象 erp_supplier
 * 
 * @author sdb
 * @date 2021-08-06
 */
public class ErpSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNum;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 备注 */
    @Excel(name = "备注")
    private String description;

    /** 是否系统自带 0==系统 1==非系统 */
    @Excel(name = "是否系统自带 0==系统 1==非系统")
    private Integer isystem;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 启用 */
    @Excel(name = "启用")
    private Integer enabled;

    /** 预收款 */
    @Excel(name = "预收款")
    private BigDecimal advanceIn;

    /** 期初应收 */
    @Excel(name = "期初应收")
    private BigDecimal beginNeedGet;

    /** 期初应付 */
    @Excel(name = "期初应付")
    private BigDecimal beginNeedPay;

    /** 累计应收 */
    @Excel(name = "累计应收")
    private BigDecimal allNeedGet;

    /** 累计应付 */
    @Excel(name = "累计应付")
    private BigDecimal allNeedPay;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 手机 */
    @Excel(name = "手机")
    private String telephone;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String taxNum;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bankName;

    /** 账号 */
    @Excel(name = "账号")
    private String accountNumber;

    /** 税率 */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setPhoneNum(String phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() 
    {
        return phoneNum;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setIsystem(Integer isystem) 
    {
        this.isystem = isystem;
    }

    public Integer getIsystem() 
    {
        return isystem;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setAdvanceIn(BigDecimal advanceIn) 
    {
        this.advanceIn = advanceIn;
    }

    public BigDecimal getAdvanceIn() 
    {
        return advanceIn;
    }
    public void setBeginNeedGet(BigDecimal beginNeedGet) 
    {
        this.beginNeedGet = beginNeedGet;
    }

    public BigDecimal getBeginNeedGet() 
    {
        return beginNeedGet;
    }
    public void setBeginNeedPay(BigDecimal beginNeedPay) 
    {
        this.beginNeedPay = beginNeedPay;
    }

    public BigDecimal getBeginNeedPay() 
    {
        return beginNeedPay;
    }
    public void setAllNeedGet(BigDecimal allNeedGet) 
    {
        this.allNeedGet = allNeedGet;
    }

    public BigDecimal getAllNeedGet() 
    {
        return allNeedGet;
    }
    public void setAllNeedPay(BigDecimal allNeedPay) 
    {
        this.allNeedPay = allNeedPay;
    }

    public BigDecimal getAllNeedPay() 
    {
        return allNeedPay;
    }
    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getFax() 
    {
        return fax;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTaxNum(String taxNum) 
    {
        this.taxNum = taxNum;
    }

    public String getTaxNum() 
    {
        return taxNum;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setAccountNumber(String accountNumber) 
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }
    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
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
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("contacts", getContacts())
            .append("phoneNum", getPhoneNum())
            .append("email", getEmail())
            .append("description", getDescription())
            .append("isystem", getIsystem())
            .append("type", getType())
            .append("enabled", getEnabled())
            .append("advanceIn", getAdvanceIn())
            .append("beginNeedGet", getBeginNeedGet())
            .append("beginNeedPay", getBeginNeedPay())
            .append("allNeedGet", getAllNeedGet())
            .append("allNeedPay", getAllNeedPay())
            .append("fax", getFax())
            .append("telephone", getTelephone())
            .append("address", getAddress())
            .append("taxNum", getTaxNum())
            .append("bankName", getBankName())
            .append("accountNumber", getAccountNumber())
            .append("taxRate", getTaxRate())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
