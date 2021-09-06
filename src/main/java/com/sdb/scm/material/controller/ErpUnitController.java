package com.sdb.scm.material.controller;

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
import com.sdb.scm.material.domain.ErpUnit;
import com.sdb.scm.material.service.IErpUnitService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 计量单位Controller
 * 
 * @author jzg
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/material/materialunit")
public class ErpUnitController extends BaseController
{
    @Autowired
    private IErpUnitService erpUnitService;

    /**
     * 查询计量单位列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpUnit erpUnit)
    {
        startPage();
        List<ErpUnit> list = erpUnitService.selectErpUnitList(erpUnit);
        return getDataTable(list);
    }

    /**
     * 导出计量单位列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:export')")
    @Log(title = "计量单位", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpUnit erpUnit)
    {
        List<ErpUnit> list = erpUnitService.selectErpUnitList(erpUnit);
        ExcelUtil<ErpUnit> util = new ExcelUtil<ErpUnit>(ErpUnit.class);
        return util.exportExcel(list, "计量单位数据");
    }

    /**
     * 获取计量单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:query')")
    @GetMapping(value = "/{unitId}")
    public AjaxResult getInfo(@PathVariable("unitId") Long unitId)
    {
        return AjaxResult.success(erpUnitService.selectErpUnitById(unitId));
    }

    /**
     * 新增计量单位
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:add')")
    @Log(title = "计量单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpUnit erpUnit)
    {
        return toAjax(erpUnitService.insertErpUnit(erpUnit));
    }

    /**
     * 修改计量单位
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:edit')")
    @Log(title = "计量单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpUnit erpUnit)
    {
        return toAjax(erpUnitService.updateErpUnit(erpUnit));
    }

    /**
     * 删除计量单位
     */
    @PreAuthorize("@ss.hasPermi('material:materialunit:remove')")
    @Log(title = "计量单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{unitIds}")
    public AjaxResult remove(@PathVariable Long[] unitIds)
    {
        return toAjax(erpUnitService.deleteErpUnitByIds(unitIds));
    }
}
