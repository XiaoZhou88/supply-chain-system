package com.sdb.scm.base.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库区设置对象 erp_deposit_region
 * 
 * @author sdb
 * @date 2021-08-13
 */
public class ErpDepositRegion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库区设置id */
    private Long depositRegionId;

    /** 库区编码 */
    @Excel(name = "库区编码")
    private String regionCode;

    /** 库区名称 */
    @Excel(name = "库区名称")
    private String regionName;

    /** 所属仓库 */
    @Excel(name = "所属仓库")
    private Long depositId;
    //解决显示仓库名称
    private ErpDeposit deposit;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 租户ID */
    private Long tanentId;

    public void setDepositRegionId(Long depositRegionId) 
    {
        this.depositRegionId = depositRegionId;
    }

    public Long getDepositRegionId() 
    {
        return depositRegionId;
    }
    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }
    public void setDepositId(Long depositId) 
    {
        this.depositId = depositId;
    }

    public Long getDepositId() 
    {
        return depositId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setTanentId(Long tanentId) 
    {
        this.tanentId = tanentId;
    }

    public Long getTanentId() 
    {
        return tanentId;
    }

    public ErpDeposit getDeposit() {
        return deposit;
    }

    public void setDeposit(ErpDeposit deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("depositRegionId", getDepositRegionId())
            .append("regionCode", getRegionCode())
            .append("regionName", getRegionName())
            .append("depositId", getDepositId())
            .append("depositName",getDeposit().getDepositName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("tanentId", getTanentId())
            .toString();
    }
}
