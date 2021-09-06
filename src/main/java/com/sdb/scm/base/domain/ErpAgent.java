package com.sdb.scm.base.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 经办人对象 erp_agent
 * 
 * @author sdb
 * @date 2021-08-14
 */
public class ErpAgent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long agentId;

    /** 类型 */
    @Excel(name = "类型")
    private String agentType;

    /** 姓名 */
    @Excel(name = "姓名")
    private String agentName;

    /** 租户id */
    private Long tenantId;

    /** 删除标记，0未删除，1删除 */
    private String deleteFlag;

    public void setAgentId(Long agentId) 
    {
        this.agentId = agentId;
    }

    public Long getAgentId() 
    {
        return agentId;
    }
    public void setAgentType(String agentType) 
    {
        this.agentType = agentType;
    }

    public String getAgentType() 
    {
        return agentType;
    }
    public void setAgentName(String agentName) 
    {
        this.agentName = agentName;
    }

    public String getAgentName() 
    {
        return agentName;
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
            .append("agentId", getAgentId())
            .append("agentType", getAgentType())
            .append("agentName", getAgentName())
            .append("tenantId", getTenantId())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
