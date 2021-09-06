package com.sdb.scm.base.domain;

import com.sdb.base.annotation.Excel;
import com.sdb.base.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 单据编号对象 erp_bill_no
 * 
 * @author jzg
 * @date 2021-08-18
 */
public class ErpBillNo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列名称 */
    private String seqName;

    /** 最小值 */
    @Excel(name = "最小值")
    private Long minValue;

    /** 最大值 */
    @Excel(name = "最大值")
    private Long maxValue;

    /** 当前值 */
    @Excel(name = "当前值")
    private Long currentVal;

    /** 增长步数 */
    @Excel(name = "增长步数")
    private Long incrementVal;

    public void setSeqName(String seqName) 
    {
        this.seqName = seqName;
    }

    public String getSeqName() 
    {
        return seqName;
    }
    public void setMinValue(Long minValue) 
    {
        this.minValue = minValue;
    }

    public Long getMinValue() 
    {
        return minValue;
    }
    public void setMaxValue(Long maxValue) 
    {
        this.maxValue = maxValue;
    }

    public Long getMaxValue() 
    {
        return maxValue;
    }
    public void setCurrentVal(Long currentVal) 
    {
        this.currentVal = currentVal;
    }

    public Long getCurrentVal() 
    {
        return currentVal;
    }
    public void setIncrementVal(Long incrementVal) 
    {
        this.incrementVal = incrementVal;
    }

    public Long getIncrementVal() 
    {
        return incrementVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("seqName", getSeqName())
            .append("minValue", getMinValue())
            .append("maxValue", getMaxValue())
            .append("currentVal", getCurrentVal())
            .append("incrementVal", getIncrementVal())
            .append("remark", getRemark())
            .toString();
    }
}
