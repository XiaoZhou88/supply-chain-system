package com.sdb.scm.base.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 收支项目对象 erp_ioitem
 * 
 * @author sdb
 * @date 2021-08-14
 */
public class ErpIoitem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long ioitemId;

    /** 名称 */
    @Excel(name = "名称")
    private String ioitemName;

    /** 收支类型 */
    @Excel(name = "收支类型")
    private String type;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    public void setIoitemId(Long ioitemId) 
    {
        this.ioitemId = ioitemId;
    }

    public Long getIoitemId() 
    {
        return ioitemId;
    }
    public void setIoitemName(String ioitemName) 
    {
        this.ioitemName = ioitemName;
    }

    public String getIoitemName() 
    {
        return ioitemName;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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
            .append("ioitemId", getIoitemId())
            .append("ioitemName", getIoitemName())
            .append("type", getType())
            .append("remark", getRemark())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
