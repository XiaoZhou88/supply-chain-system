package com.sdb.scm.purchase.domain;

import java.math.BigDecimal;
import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 进销存单据子对象 erp_jxc_item
 * 
 * @author jzg
 * @date 2021-08-17
 */
public class ErpJxcItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long jxcItemId;

    /** 表头Id */
    @Excel(name = "表头Id")
    private Long headerId;

    /** 商品Id */
    @Excel(name = "商品Id")
    private Long materialId;

    /** 商品扩展id */
    @Excel(name = "商品扩展id")
    private Long materialExtendId;

    /** 商品计量单位 */
    @Excel(name = "商品计量单位")
    private String materialUnit;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal operNumber;

    /** 基础数量，如kg、瓶 */
    @Excel(name = "基础数量，如kg、瓶")
    private BigDecimal basicNumber;

    /** 单价 */
    private BigDecimal unitPrice;

    /** 含税单价 */
    @Excel(name = "含税单价")
    private BigDecimal taxUnitPrice;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal allPrice;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 运杂费 */
    @Excel(name = "运杂费")
    private BigDecimal incidentals;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long depotId;

    /** 调拨时，对方仓库Id */
    @Excel(name = "调拨时，对方仓库Id")
    private Long anotherDepotId;

    /** 税率 */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /** 税额 */
    @Excel(name = "税额")
    private BigDecimal taxMoney;

    /** 价税合计 */
    @Excel(name = "价税合计")
    private BigDecimal taxLastMoney;

    /** 自定义字段1-名称 */
    @Excel(name = "自定义字段1-名称")
    private String otherField1;

    /** 自定义字段2-型号 */
    @Excel(name = "自定义字段2-型号")
    private String otherField2;

    /** 自定义字段3-制造商 */
    @Excel(name = "自定义字段3-制造商")
    private String otherField3;

    /** 自定义字段4-名称 */
    @Excel(name = "自定义字段4-名称")
    private String otherField4;

    /** 自定义字段5-名称 */
    @Excel(name = "自定义字段5-名称")
    private String otherField5;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String materialType;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    @Excel(name = "删除标记，0未删除，1删除")
    private String deleteFlag;

    public void setJxcItemId(Long jxcItemId) 
    {
        this.jxcItemId = jxcItemId;
    }

    public Long getJxcItemId() 
    {
        return jxcItemId;
    }
    public void setHeaderId(Long headerId) 
    {
        this.headerId = headerId;
    }

    public Long getHeaderId() 
    {
        return headerId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialExtendId(Long materialExtendId) 
    {
        this.materialExtendId = materialExtendId;
    }

    public Long getMaterialExtendId() 
    {
        return materialExtendId;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setOperNumber(BigDecimal operNumber) 
    {
        this.operNumber = operNumber;
    }

    public BigDecimal getOperNumber() 
    {
        return operNumber;
    }
    public void setBasicNumber(BigDecimal basicNumber) 
    {
        this.basicNumber = basicNumber;
    }

    public BigDecimal getBasicNumber() 
    {
        return basicNumber;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setTaxUnitPrice(BigDecimal taxUnitPrice) 
    {
        this.taxUnitPrice = taxUnitPrice;
    }

    public BigDecimal getTaxUnitPrice() 
    {
        return taxUnitPrice;
    }
    public void setAllPrice(BigDecimal allPrice) 
    {
        this.allPrice = allPrice;
    }

    public BigDecimal getAllPrice() 
    {
        return allPrice;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setIncidentals(BigDecimal incidentals) 
    {
        this.incidentals = incidentals;
    }

    public BigDecimal getIncidentals() 
    {
        return incidentals;
    }
    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setAnotherDepotId(Long anotherDepotId) 
    {
        this.anotherDepotId = anotherDepotId;
    }

    public Long getAnotherDepotId() 
    {
        return anotherDepotId;
    }
    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
    }
    public void setTaxMoney(BigDecimal taxMoney) 
    {
        this.taxMoney = taxMoney;
    }

    public BigDecimal getTaxMoney() 
    {
        return taxMoney;
    }
    public void setTaxLastMoney(BigDecimal taxLastMoney) 
    {
        this.taxLastMoney = taxLastMoney;
    }

    public BigDecimal getTaxLastMoney() 
    {
        return taxLastMoney;
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
    public void setOtherField4(String otherField4) 
    {
        this.otherField4 = otherField4;
    }

    public String getOtherField4() 
    {
        return otherField4;
    }
    public void setOtherField5(String otherField5) 
    {
        this.otherField5 = otherField5;
    }

    public String getOtherField5() 
    {
        return otherField5;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
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
            .append("jxcItemId", getJxcItemId())
            .append("headerId", getHeaderId())
            .append("materialId", getMaterialId())
            .append("materialExtendId", getMaterialExtendId())
            .append("materialUnit", getMaterialUnit())
            .append("operNumber", getOperNumber())
            .append("basicNumber", getBasicNumber())
            .append("unitPrice", getUnitPrice())
            .append("taxUnitPrice", getTaxUnitPrice())
            .append("allPrice", getAllPrice())
            .append("remark", getRemark())
            .append("img", getImg())
            .append("incidentals", getIncidentals())
            .append("depotId", getDepotId())
            .append("anotherDepotId", getAnotherDepotId())
            .append("taxRate", getTaxRate())
            .append("taxMoney", getTaxMoney())
            .append("taxLastMoney", getTaxLastMoney())
            .append("otherField1", getOtherField1())
            .append("otherField2", getOtherField2())
            .append("otherField3", getOtherField3())
            .append("otherField4", getOtherField4())
            .append("otherField5", getOtherField5())
            .append("materialType", getMaterialType())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
