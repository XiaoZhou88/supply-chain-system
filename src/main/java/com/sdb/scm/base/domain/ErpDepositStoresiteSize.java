package com.sdb.scm.base.domain;

import java.math.BigDecimal;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库位尺寸对象 erp_deposit_storesite_size
 * 
 * @author sdb
 * @date 2021-08-13
 */
public class ErpDepositStoresiteSize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库位尺寸id */
    private Long storesizeId;

    /** 库位尺寸名称 */
    @Excel(name = "库位尺寸名称")
    private String storesizeName;

    /** 库位长度(单位:毫米) */
    @Excel(name = "库位长度(单位:毫米)")
    private Long length;

    /** 库位宽度(单位:毫米) */
    @Excel(name = "库位宽度(单位:毫米)")
    private Long width;

    /** 库位高度(单位:毫米) */
    @Excel(name = "库位高度(单位:毫米)")
    private Long height;

    /** 最大重量(单位:千克) */
    @Excel(name = "最大重量(单位:千克)")
    private BigDecimal maxWeight;

    /** 最大托盘(单位:件) */
    @Excel(name = "最大托盘(单位:件)")
    private Long maxTray;

    /** 最大体积(单位:立方毫米) */
    @Excel(name = "最大体积(单位:立方毫米)")
    private BigDecimal maxVolume;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 租户ID */
    private Long tenantId;

    public void setStoresizeId(Long storesizeId) 
    {
        this.storesizeId = storesizeId;
    }

    public Long getStoresizeId() 
    {
        return storesizeId;
    }
    public void setStoresizeName(String storesizeName) 
    {
        this.storesizeName = storesizeName;
    }

    public String getStoresizeName() 
    {
        return storesizeName;
    }
    public void setLength(Long length) 
    {
        this.length = length;
    }

    public Long getLength() 
    {
        return length;
    }
    public void setWidth(Long width) 
    {
        this.width = width;
    }

    public Long getWidth() 
    {
        return width;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setMaxWeight(BigDecimal maxWeight) 
    {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getMaxWeight() 
    {
        return maxWeight;
    }
    public void setMaxTray(Long maxTray) 
    {
        this.maxTray = maxTray;
    }

    public Long getMaxTray() 
    {
        return maxTray;
    }
    public void setMaxVolume(BigDecimal maxVolume) 
    {
        this.maxVolume = maxVolume;
    }

    public BigDecimal getMaxVolume() 
    {
        return maxVolume;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
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
            .append("storesizeId", getStoresizeId())
            .append("storesizeName", getStoresizeName())
            .append("length", getLength())
            .append("width", getWidth())
            .append("height", getHeight())
            .append("maxWeight", getMaxWeight())
            .append("maxTray", getMaxTray())
            .append("maxVolume", getMaxVolume())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("tenantId", getTenantId())
            .toString();
    }
}
