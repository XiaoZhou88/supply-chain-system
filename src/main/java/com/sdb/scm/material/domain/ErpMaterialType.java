package com.sdb.scm.material.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品类型对象 erp_material_type
 * 
 * @author sdb
 * @date 2021-08-14
 */
public class ErpMaterialType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型id */
    private Long materialTypeId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 编号 */
    @Excel(name = "编号")
    private String serialNo;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    public void setMaterialTypeId(Long materialTypeId) 
    {
        this.materialTypeId = materialTypeId;
    }

    public Long getMaterialTypeId() 
    {
        return materialTypeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setSerialNo(String serialNo) 
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo() 
    {
        return serialNo;
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
            .append("materialTypeId", getMaterialTypeId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("typeName", getTypeName())
            .append("orderNum", getOrderNum())
            .append("serialNo", getSerialNo())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
