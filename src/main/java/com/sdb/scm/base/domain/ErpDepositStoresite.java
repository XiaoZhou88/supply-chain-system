package com.sdb.scm.base.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库位设置对象 erp_deposit_storesite
 * 
 * @author sdb
 * @date 2021-08-09
 */
public class ErpDepositStoresite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库位(储位)设置id */
    private Long depositStoresiteId;

    /** 库位编码 */
    @Excel(name = "库位编码")
    private String storesiteCode;

    /** 库位名称 */
    @Excel(name = "库位名称")
    private String storesiteName;

    /** 库位条码 */
    private String storesiteBarcode;

    /** 所属库区 */
    @Excel(name = "所属库区")
    private Long regionId;

    /** 库位类型(数据字典：收货、发货、存储、暂存、良品、不良等) */
    @Excel(name = "库位类型(数据字典：收货、发货、存储、暂存、良品、不良等)")
    private String storeType;

    /** 库位属性(数据字典：冷藏、恒温、常温等) */
    @Excel(name = "库位属性(数据字典：冷藏、恒温、常温等)")
    private String storeAttribute;

    /** 库位尺寸主键 */
    private Long storeSizeId;

    /** 出库口 */
    @Excel(name = "出库口")
    private String outbound;

    /** 空库位标识(Y是 N否) */
    @Excel(name = "空库位标识(Y是 N否)")
    private String isEmpty;

    /** 是否停用(0:正常 1:停用) */
    private String isDisable;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 租户ID */
    private Long tenantId;

    public void setDepositStoresiteId(Long depositStoresiteId) 
    {
        this.depositStoresiteId = depositStoresiteId;
    }

    public Long getDepositStoresiteId() 
    {
        return depositStoresiteId;
    }
    public void setStoresiteCode(String storesiteCode) 
    {
        this.storesiteCode = storesiteCode;
    }

    public String getStoresiteCode() 
    {
        return storesiteCode;
    }
    public void setStoresiteName(String storesiteName) 
    {
        this.storesiteName = storesiteName;
    }

    public String getStoresiteName() 
    {
        return storesiteName;
    }
    public void setStoresiteBarcode(String storesiteBarcode) 
    {
        this.storesiteBarcode = storesiteBarcode;
    }

    public String getStoresiteBarcode() 
    {
        return storesiteBarcode;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }
    public void setStoreType(String storeType) 
    {
        this.storeType = storeType;
    }

    public String getStoreType() 
    {
        return storeType;
    }
    public void setStoreAttribute(String storeAttribute) 
    {
        this.storeAttribute = storeAttribute;
    }

    public String getStoreAttribute() 
    {
        return storeAttribute;
    }
    public void setStoreSizeId(Long storeSizeId) 
    {
        this.storeSizeId = storeSizeId;
    }

    public Long getStoreSizeId() 
    {
        return storeSizeId;
    }
    public void setOutbound(String outbound) 
    {
        this.outbound = outbound;
    }

    public String getOutbound() 
    {
        return outbound;
    }
    public void setIsEmpty(String isEmpty) 
    {
        this.isEmpty = isEmpty;
    }

    public String getIsEmpty() 
    {
        return isEmpty;
    }
    public void setIsDisable(String isDisable) 
    {
        this.isDisable = isDisable;
    }

    public String getIsDisable() 
    {
        return isDisable;
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
            .append("depositStoresiteId", getDepositStoresiteId())
            .append("storesiteCode", getStoresiteCode())
            .append("storesiteName", getStoresiteName())
            .append("storesiteBarcode", getStoresiteBarcode())
            .append("regionId", getRegionId())
            .append("storeType", getStoreType())
            .append("storeAttribute", getStoreAttribute())
            .append("storeSizeId", getStoreSizeId())
            .append("outbound", getOutbound())
            .append("isEmpty", getIsEmpty())
            .append("isDisable", getIsDisable())
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
