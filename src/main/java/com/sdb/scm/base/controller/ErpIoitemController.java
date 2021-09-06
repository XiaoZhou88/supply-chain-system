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
import com.sdb.scm.base.domain.ErpIoitem;
import com.sdb.scm.base.service.IErpIoitemService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 收支项目Controller
 * 
 * @author sdb
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/base/ioitem")
public class ErpIoitemController extends BaseController
{
    @Autowired
    private IErpIoitemService erpIoitemService;

    /**
     * 查询收支项目列表
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpIoitem erpIoitem)
    {
        startPage();
        List<ErpIoitem> list = erpIoitemService.selectErpIoitemList(erpIoitem);
        return getDataTable(list);
    }

    /**
     * 导出收支项目列表
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:export')")
    @Log(title = "收支项目", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpIoitem erpIoitem)
    {
        List<ErpIoitem> list = erpIoitemService.selectErpIoitemList(erpIoitem);
        ExcelUtil<ErpIoitem> util = new ExcelUtil<ErpIoitem>(ErpIoitem.class);
        return util.exportExcel(list, "收支项目数据");
    }

    /**
     * 获取收支项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:query')")
    @GetMapping(value = "/{ioitemId}")
    public AjaxResult getInfo(@PathVariable("ioitemId") Long ioitemId)
    {
        return AjaxResult.success(erpIoitemService.selectErpIoitemById(ioitemId));
    }

    /**
     * 新增收支项目
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:add')")
    @Log(title = "收支项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpIoitem erpIoitem)
    {
        return toAjax(erpIoitemService.insertErpIoitem(erpIoitem));
    }

    /**
     * 修改收支项目
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:edit')")
    @Log(title = "收支项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpIoitem erpIoitem)
    {
        return toAjax(erpIoitemService.updateErpIoitem(erpIoitem));
    }

    /**
     * 删除收支项目
     */
    @PreAuthorize("@ss.hasPermi('base:ioitem:remove')")
    @Log(title = "收支项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ioitemIds}")
    public AjaxResult remove(@PathVariable Long[] ioitemIds)
    {
        return toAjax(erpIoitemService.deleteErpIoitemByIds(ioitemIds));
    }
}
