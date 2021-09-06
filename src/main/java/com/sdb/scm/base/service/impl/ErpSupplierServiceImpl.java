package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpSupplierMapper;
import com.sdb.scm.base.domain.ErpSupplier;
import com.sdb.scm.base.service.IErpSupplierService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-06
 */
@Service
public class ErpSupplierServiceImpl implements IErpSupplierService 
{
    @Autowired
    private ErpSupplierMapper erpSupplierMapper;

    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息ID
     * @return 供应商信息
     */
    @Override
    public ErpSupplier selectErpSupplierById(Long supplierId)
    {
        return erpSupplierMapper.selectErpSupplierById(supplierId);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param erpSupplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<ErpSupplier> selectErpSupplierList(ErpSupplier erpSupplier)
    {
        return erpSupplierMapper.selectErpSupplierList(erpSupplier);
    }

    /**
     * 新增供应商信息
     * 
     * @param erpSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int insertErpSupplier(ErpSupplier erpSupplier)
    {
        return erpSupplierMapper.insertErpSupplier(erpSupplier);
    }

    /**
     * 修改供应商信息
     * 
     * @param erpSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int updateErpSupplier(ErpSupplier erpSupplier)
    {
        return erpSupplierMapper.updateErpSupplier(erpSupplier);
    }

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteErpSupplierByIds(Long[] supplierIds)
    {
        return erpSupplierMapper.deleteErpSupplierByIds(supplierIds);
    }

    /**
     * 删除供应商信息信息
     * 
     * @param supplierId 供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteErpSupplierById(Long supplierId)
    {
        return erpSupplierMapper.deleteErpSupplierById(supplierId);
    }
}
