package com.sdb.scm.material.domain;

import java.math.BigDecimal;
import java.util.List;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品信息对象 erp_material
 * 
 * @author sdb
 * @date 2021-08-14
 */
public class ErpMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialId;

    /** 商品类型id */
    @Excel(name = "商品类型id")
    private Long materialtypeId;
    private ErpMaterialType materialType;

    /** 名称 */
    @Excel(name = "名称")
    private String materialName;

    /** 制造商 */
    @Excel(name = "制造商")
    private String mfrs;

    /** 安全存量（KG） */
    private BigDecimal safetyStock;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 规格 */
    @Excel(name = "规格")
    private String standard;

    /** 颜色 */
    private String color;

    /** 单位-单个 */
    @Excel(name = "单位-单个")
    private String unit;

    /** 图片名称 */
    private String imgName;

    /** 计量单位Id */
    private Long unitId;

    /** 启用 0-禁用  1-启用 */
    private Integer enabled;

    /** 自定义1 */
    private String otherField1;

    /** 自定义2 */
    private String otherField2;

    /** 自定义3 */
    private String otherField3;

    /** 是否开启序列号，0否，1是 */
    private String enableSerialNumber;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    /** 商品扩展信息信息 */
    private List<ErpExmaterial> erpExmaterialList;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialtypeId(Long materialtypeId) 
    {
        this.materialtypeId = materialtypeId;
    }

    public Long getMaterialtypeId() 
    {
        return materialtypeId;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMfrs(String mfrs) 
    {
        this.mfrs = mfrs;
    }

    public String getMfrs() 
    {
        return mfrs;
    }
    public void setSafetyStock(BigDecimal safetyStock) 
    {
        this.safetyStock = safetyStock;
    }

    public BigDecimal getSafetyStock() 
    {
        return safetyStock;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setStandard(String standard) 
    {
        this.standard = standard;
    }

    public String getStandard() 
    {
        return standard;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setImgName(String imgName) 
    {
        this.imgName = imgName;
    }

    public String getImgName() 
    {
        return imgName;
    }
    public void setUnitId(Long unitId) 
    {
        this.unitId = unitId;
    }

    public Long getUnitId() 
    {
        return unitId;
    }
    public void setEnabled(Integer enabled) 
    {
        this.enabled = enabled;
    }

    public Integer getEnabled() 
    {
        return enabled;
    }
    public void setOtherField1(String otherField1) 
    {
        this.otherField1 = otherField1;
    }

    public String getOtherField1() 
    {
        return otherField1;
    }
    public void setOtherField2(String otherField2) 
    {
        this.otherField2 = otherField2;
    }

    public String getOtherField2() 
    {
        return otherField2;
    }
    public void setOtherField3(String otherField3) 
    {
        this.otherField3 = otherField3;
    }

    public String getOtherField3() 
    {
        return otherField3;
    }
    public void setEnableSerialNumber(String enableSerialNumber) 
    {
        this.enableSerialNumber = enableSerialNumber;
    }

    public String getEnableSerialNumber() 
    {
        return enableSerialNumber;
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

    public List<ErpExmaterial> getErpExmaterialList()
    {
        return erpExmaterialList;
    }

    public void setErpExmaterialList(List<ErpExmaterial> erpExmaterialList)
    {
        this.erpExmaterialList = erpExmaterialList;
    }

    public ErpMaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(ErpMaterialType materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("materialtypeId", getMaterialtypeId())
            .append("materialTypeName",getMaterialType().getTypeName())
            .append("materialName", getMaterialName())
            .append("mfrs", getMfrs())
            .append("safetyStock", getSafetyStock())
            .append("model", getModel())
            .append("standard", getStandard())
            .append("color", getColor())
            .append("unit", getUnit())
            .append("remark", getRemark())
            .append("imgName", getImgName())
            .append("unitId", getUnitId())
            .append("enabled", getEnabled())
            .append("otherField1", getOtherField1())
            .append("otherField2", getOtherField2())
            .append("otherField3", getOtherField3())
            .append("enableSerialNumber", getEnableSerialNumber())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .append("erpExmaterialList", getErpExmaterialList())
            .toString();
    }
}
