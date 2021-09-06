package com.sdb.scm.base.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdb.base.annotation.Log;
import com.sdb.base.core.controller.BaseController;
import com.sdb.base.core.domain.AjaxResult;
import com.sdb.base.enums.BusinessType;
import com.sdb.scm.base.domain.ErpSupplier;
import com.sdb.scm.base.service.IErpSupplierService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 供应商信息Controller
 * 
 * @author sdb
 * @date 2021-08-06
 */
@RestController
@RequestMapping("/base/supplier")
public class ErpSupplierController extends BaseController
{
    @Autowired
    private IErpSupplierService erpSupplierService;

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpSupplier erpSupplier)
    {
        startPage();
        List<ErpSupplier> list = erpSupplierService.selectErpSupplierList(erpSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:export')")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpSupplier erpSupplier)
    {
        List<ErpSupplier> list = erpSupplierService.selectErpSupplierList(erpSupplier);
        ExcelUtil<ErpSupplier> util = new ExcelUtil<ErpSupplier>(ErpSupplier.class);
        return util.exportExcel(list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId)
    {
        return AjaxResult.success(erpSupplierService.selectErpSupplierById(supplierId));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpSupplier erpSupplier)
    {
        return toAjax(erpSupplierService.insertErpSupplier(erpSupplier));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpSupplier erpSupplier)
    {
        return toAjax(erpSupplierService.updateErpSupplier(erpSupplier));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('base:supplier:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplierIds}")
    public AjaxResult remove(@PathVariable Long[] supplierIds)
    {
        return toAjax(erpSupplierService.deleteErpSupplierByIds(supplierIds));
    }
}
