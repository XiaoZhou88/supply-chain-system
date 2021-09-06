package com.sdb.scm.material.mapper;

import java.util.List;
import com.sdb.scm.material.domain.ErpUnit;

/**
 * 计量单位Mapper接口
 * 
 * @author jzg
 * @date 2021-08-14
 */
public interface ErpUnitMapper 
{
    /**
     * 查询计量单位
     * 
     * @param unitId 计量单位ID
     * @return 计量单位
     */
    public ErpUnit selectErpUnitById(Long unitId);

    /**
     * 查询计量单位列表
     * 
     * @param erpUnit 计量单位
     * @return 计量单位集合
     */
    public List<ErpUnit> selectErpUnitList(ErpUnit erpUnit);

    /**
     * 新增计量单位
     * 
     * @param erpUnit 计量单位
     * @return 结果
     */
    public int insertErpUnit(ErpUnit erpUnit);

    /**
     * 修改计量单位
     * 
     * @param erpUnit 计量单位
     * @return 结果
     */
    public int updateErpUnit(ErpUnit erpUnit);

    /**
     * 删除计量单位
     * 
     * @param unitId 计量单位ID
     * @return 结果
     */
    public int deleteErpUnitById(Long unitId);

    /**
     * 批量删除计量单位
     * 
     * @param unitIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpUnitByIds(Long[] unitIds);
}
