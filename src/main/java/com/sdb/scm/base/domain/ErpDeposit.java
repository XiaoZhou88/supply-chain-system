package com.sdb.scm.base.domain;

import java.math.BigDecimal;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import com.sdb.base.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 仓库对象 erp_deposit
 * 
 * @author sdb
 * @date 2021-08-11
 */
public class ErpDeposit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long depositId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String depositName;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String address;

    /** 仓储费 */
    @Excel(name = "仓储费")
    private BigDecimal warehousing;

    /** 搬运费 */
    @Excel(name = "搬运费")
    private BigDecimal truckage;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** 排序 */
    private String sort;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long principal;
    ////负责人id对应的姓名
    private SysUser user;
    //////

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    /** 是否默认 */
    private Integer isDefault;

    public void setDepositId(Long depositId) 
    {
        this.depositId = depositId;
    }

    public Long getDepositId() 
    {
        return depositId;
    }
    public void setDepositName(String depositName) 
    {
        this.depositName = depositName;
    }

    public String getDepositName() 
    {
        return depositName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setWarehousing(BigDecimal warehousing) 
    {
        this.warehousing = warehousing;
    }

    public BigDecimal getWarehousing() 
    {
        return warehousing;
    }
    public void setTruckage(BigDecimal truckage) 
    {
        this.truckage = truckage;
    }

    public BigDecimal getTruckage() 
    {
        return truckage;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setPrincipal(Long principal) 
    {
        this.principal = principal;
    }

    public Long getPrincipal() 
    {
        return principal;
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
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }

    ////
    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("depositId", getDepositId())
            .append("depositName", getDepositName())
            .append("address", getAddress())
            .append("warehousing", getWarehousing())
            .append("truckage", getTruckage())
            .append("type", getType())
            .append("sort", getSort())
            .append("remark", getRemark())
            .append("principal", getPrincipal())
            .append("principalName",getUser().getUserName())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .append("isDefault", getIsDefault())
            .toString();
    }
}
