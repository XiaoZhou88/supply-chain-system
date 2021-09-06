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
import com.sdb.scm.base.domain.ErpDepositRegion;
import com.sdb.scm.base.service.IErpDepositRegionService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 库区设置Controller
 * 
 * @author sdb
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/base/region")
public class ErpDepositRegionController extends BaseController
{
    @Autowired
    private IErpDepositRegionService erpDepositRegionService;

    /**
     * 查询库区设置列表
     */
    @PreAuthorize("@ss.hasPermi('base:region:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpDepositRegion erpDepositRegion)
    {
        startPage();
        List<ErpDepositRegion> list = erpDepositRegionService.selectErpDepositRegionList(erpDepositRegion);
        return getDataTable(list);
    }

    /**
     * 导出库区设置列表
     */
    @PreAuthorize("@ss.hasPermi('base:region:export')")
    @Log(title = "库区设置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpDepositRegion erpDepositRegion)
    {
        List<ErpDepositRegion> list = erpDepositRegionService.selectErpDepositRegionList(erpDepositRegion);
        ExcelUtil<ErpDepositRegion> util = new ExcelUtil<ErpDepositRegion>(ErpDepositRegion.class);
        return util.exportExcel(list, "库区设置数据");
    }

    /**
     * 获取库区设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:region:query')")
    @GetMapping(value = "/{depositRegionId}")
    public AjaxResult getInfo(@PathVariable("depositRegionId") Long depositRegionId)
    {
        return AjaxResult.success(erpDepositRegionService.selectErpDepositRegionById(depositRegionId));
    }

    /**
     * 新增库区设置
     */
    @PreAuthorize("@ss.hasPermi('base:region:add')")
    @Log(title = "库区设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpDepositRegion erpDepositRegion)
    {
        return toAjax(erpDepositRegionService.insertErpDepositRegion(erpDepositRegion));
    }

    /**
     * 修改库区设置
     */
    @PreAuthorize("@ss.hasPermi('base:region:edit')")
    @Log(title = "库区设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpDepositRegion erpDepositRegion)
    {
        return toAjax(erpDepositRegionService.updateErpDepositRegion(erpDepositRegion));
    }

    /**
     * 删除库区设置
     */
    @PreAuthorize("@ss.hasPermi('base:region:remove')")
    @Log(title = "库区设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{depositRegionIds}")
    public AjaxResult remove(@PathVariable Long[] depositRegionIds)
    {
        return toAjax(erpDepositRegionService.deleteErpDepositRegionByIds(depositRegionIds));
    }
}
