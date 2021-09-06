package com.sdb.scm.base.service;

import java.util.List;
import com.sdb.scm.base.domain.ErpSupplier;

/**
 * 供应商信息Service接口
 * 
 * @author sdb
 * @date 2021-08-06
 */
public interface IErpSupplierService 
{
    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息ID
     * @return 供应商信息
     */
    public ErpSupplier selectErpSupplierById(Long supplierId);

    /**
     * 查询供应商信息列表
     * 
     * @param erpSupplier 供应商信息
     * @return 供应商信息集合
     */
    public List<ErpSupplier> selectErpSupplierList(ErpSupplier erpSupplier);

    /**
     * 新增供应商信息
     * 
     * @param erpSupplier 供应商信息
     * @return 结果
     */
    public int insertErpSupplier(ErpSupplier erpSupplier);

    /**
     * 修改供应商信息
     * 
     * @param erpSupplier 供应商信息
     * @return 结果
     */
    public int updateErpSupplier(ErpSupplier erpSupplier);

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的供应商信息ID
     * @return 结果
     */
    public int deleteErpSupplierByIds(Long[] supplierIds);

    /**
     * 删除供应商信息信息
     * 
     * @param supplierId 供应商信息ID
     * @return 结果
     */
    public int deleteErpSupplierById(Long supplierId);
}
