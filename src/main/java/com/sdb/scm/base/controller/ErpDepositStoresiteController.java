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
import com.sdb.scm.base.domain.ErpDepositStoresite;
import com.sdb.scm.base.service.IErpDepositStoresiteService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 库位设置Controller
 * 
 * @author sdb
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/base/storesite")
public class ErpDepositStoresiteController extends BaseController
{
    @Autowired
    private IErpDepositStoresiteService erpDepositStoresiteService;

    /**
     * 查询库位设置列表
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpDepositStoresite erpDepositStoresite)
    {
        startPage();
        List<ErpDepositStoresite> list = erpDepositStoresiteService.selectErpDepositStoresiteList(erpDepositStoresite);
        return getDataTable(list);
    }

    /**
     * 导出库位设置列表
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:export')")
    @Log(title = "库位设置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpDepositStoresite erpDepositStoresite)
    {
        List<ErpDepositStoresite> list = erpDepositStoresiteService.selectErpDepositStoresiteList(erpDepositStoresite);
        ExcelUtil<ErpDepositStoresite> util = new ExcelUtil<ErpDepositStoresite>(ErpDepositStoresite.class);
        return util.exportExcel(list, "库位设置数据");
    }

    /**
     * 获取库位设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:query')")
    @GetMapping(value = "/{depositStoresiteId}")
    public AjaxResult getInfo(@PathVariable("depositStoresiteId") Long depositStoresiteId)
    {
        return AjaxResult.success(erpDepositStoresiteService.selectErpDepositStoresiteById(depositStoresiteId));
    }

    /**
     * 新增库位设置
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:add')")
    @Log(title = "库位设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpDepositStoresite erpDepositStoresite)
    {
        return toAjax(erpDepositStoresiteService.insertErpDepositStoresite(erpDepositStoresite));
    }

    /**
     * 修改库位设置
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:edit')")
    @Log(title = "库位设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpDepositStoresite erpDepositStoresite)
    {
        return toAjax(erpDepositStoresiteService.updateErpDepositStoresite(erpDepositStoresite));
    }

    /**
     * 删除库位设置
     */
    @PreAuthorize("@ss.hasPermi('base:storesite:remove')")
    @Log(title = "库位设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{depositStoresiteIds}")
    public AjaxResult remove(@PathVariable Long[] depositStoresiteIds)
    {
        return toAjax(erpDepositStoresiteService.deleteErpDepositStoresiteByIds(depositStoresiteIds));
    }
}
