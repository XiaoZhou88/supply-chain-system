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
import com.sdb.scm.base.domain.ErpDepositStoresiteSize;
import com.sdb.scm.base.service.IErpDepositStoresiteSizeService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 库位尺寸Controller
 * 
 * @author sdb
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/base/storesize")
public class ErpDepositStoresiteSizeController extends BaseController
{
    @Autowired
    private IErpDepositStoresiteSizeService erpDepositStoresiteSizeService;

    /**
     * 查询库位尺寸列表
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        startPage();
        List<ErpDepositStoresiteSize> list = erpDepositStoresiteSizeService.selectErpDepositStoresiteSizeList(erpDepositStoresiteSize);
        return getDataTable(list);
    }

    /**
     * 导出库位尺寸列表
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:export')")
    @Log(title = "库位尺寸", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        List<ErpDepositStoresiteSize> list = erpDepositStoresiteSizeService.selectErpDepositStoresiteSizeList(erpDepositStoresiteSize);
        ExcelUtil<ErpDepositStoresiteSize> util = new ExcelUtil<ErpDepositStoresiteSize>(ErpDepositStoresiteSize.class);
        return util.exportExcel(list, "库位尺寸数据");
    }

    /**
     * 获取库位尺寸详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:query')")
    @GetMapping(value = "/{storesizeId}")
    public AjaxResult getInfo(@PathVariable("storesizeId") Long storesizeId)
    {
        return AjaxResult.success(erpDepositStoresiteSizeService.selectErpDepositStoresiteSizeById(storesizeId));
    }

    /**
     * 新增库位尺寸
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:add')")
    @Log(title = "库位尺寸", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        return toAjax(erpDepositStoresiteSizeService.insertErpDepositStoresiteSize(erpDepositStoresiteSize));
    }

    /**
     * 修改库位尺寸
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:edit')")
    @Log(title = "库位尺寸", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpDepositStoresiteSize erpDepositStoresiteSize)
    {
        return toAjax(erpDepositStoresiteSizeService.updateErpDepositStoresiteSize(erpDepositStoresiteSize));
    }

    /**
     * 删除库位尺寸
     */
    @PreAuthorize("@ss.hasPermi('base:storesize:remove')")
    @Log(title = "库位尺寸", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storesizeIds}")
    public AjaxResult remove(@PathVariable Long[] storesizeIds)
    {
        return toAjax(erpDepositStoresiteSizeService.deleteErpDepositStoresiteSizeByIds(storesizeIds));
    }
}
