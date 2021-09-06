package com.sdb.scm.material.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 计量单位对象 erp_unit
 * 
 * @author jzg
 * @date 2021-08-14
 */
public class ErpUnit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long unitId;

    /** 名称，支持多单位 */
    @Excel(name = "名称，支持多单位")
    private String unitName;

    /** 基础单位 */
    @Excel(name = "基础单位")
    private String basicUnit;

    /** 副单位 */
    @Excel(name = "副单位")
    private String otherUnit;

    /** 比例 */
    @Excel(name = "比例")
    private Long ratio;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    public void setUnitId(Long unitId) 
    {
        this.unitId = unitId;
    }

    public Long getUnitId() 
    {
        return unitId;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setBasicUnit(String basicUnit) 
    {
        this.basicUnit = basicUnit;
    }

    public String getBasicUnit() 
    {
        return basicUnit;
    }
    public void setOtherUnit(String otherUnit) 
    {
        this.otherUnit = otherUnit;
    }

    public String getOtherUnit() 
    {
        return otherUnit;
    }
    public void setRatio(Long ratio) 
    {
        this.ratio = ratio;
    }

    public Long getRatio() 
    {
        return ratio;
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
            .append("unitId", getUnitId())
            .append("unitName", getUnitName())
            .append("basicUnit", getBasicUnit())
            .append("otherUnit", getOtherUnit())
            .append("ratio", getRatio())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
