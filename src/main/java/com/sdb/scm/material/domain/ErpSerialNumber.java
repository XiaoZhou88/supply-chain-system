package com.sdb.scm.material.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 序列号对象 erp_serial_number
 * 
 * @author jzg
 * @date 2021-08-14
 */
public class ErpSerialNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long serialId;

    /** 产品表id */
    @Excel(name = "产品表id")
    private Long materialId;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialNumber;

    /** 是否卖出，0未卖出，1卖出 */
    @Excel(name = "是否卖出，0未卖出，1卖出")
    private String isSell;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    /** 创建人 */
    private Long creator;

    /** 更新人 */
    private Long updater;

    /** 进销存单据主表id，用于跟踪序列号流向 */
    @Excel(name = "进销存单据主表id，用于跟踪序列号流向")
    private Long jxcHeadId;

    /** 租户id */
    private Long tenantId;

    public void setSerialId(Long serialId) 
    {
        this.serialId = serialId;
    }

    public Long getSerialId() 
    {
        return serialId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }
    public void setIsSell(String isSell) 
    {
        this.isSell = isSell;
    }

    public String getIsSell() 
    {
        return isSell;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setCreator(Long creator) 
    {
        this.creator = creator;
    }

    public Long getCreator() 
    {
        return creator;
    }
    public void setUpdater(Long updater) 
    {
        this.updater = updater;
    }

    public Long getUpdater() 
    {
        return updater;
    }
    public void setJxcHeadId(Long jxcHeadId) 
    {
        this.jxcHeadId = jxcHeadId;
    }

    public Long getJxcHeadId() 
    {
        return jxcHeadId;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("serialId", getSerialId())
            .append("materialId", getMaterialId())
            .append("serialNumber", getSerialNumber())
            .append("isSell", getIsSell())
            .append("remark", getRemark())
            .append("deleteFlag", getDeleteFlag())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("updateTime", getUpdateTime())
            .append("updater", getUpdater())
            .append("jxcHeadId", getJxcHeadId())
            .append("tenantId", getTenantId())
            .toString();
    }
}
