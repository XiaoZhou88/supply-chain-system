package com.sdb.scm.financial.controller;

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
import com.sdb.scm.financial.domain.ErpAccountHead;
import com.sdb.scm.financial.service.IErpAccountHeadService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 收入单Controller
 * 
 * @author sdb
 * @date 2021-08-16
 */
@RestController
@RequestMapping("/financial/itemin")
public class ErpAccountHeadController extends BaseController
{
    @Autowired
    private IErpAccountHeadService erpAccountHeadService;

    /**
     * 查询收入单列表
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpAccountHead erpAccountHead)
    {
        startPage();
        List<ErpAccountHead> list = erpAccountHeadService.selectErpAccountHeadList(erpAccountHead);
        return getDataTable(list);
    }

    /**
     * 导出收入单列表
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:export')")
    @Log(title = "收入单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpAccountHead erpAccountHead)
    {
        List<ErpAccountHead> list = erpAccountHeadService.selectErpAccountHeadList(erpAccountHead);
        ExcelUtil<ErpAccountHead> util = new ExcelUtil<ErpAccountHead>(ErpAccountHead.class);
        return util.exportExcel(list, "收入单数据");
    }

    /**
     * 获取收入单详细信息
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:query')")
    @GetMapping(value = "/{accountHeadId}")
    public AjaxResult getInfo(@PathVariable("accountHeadId") Long accountHeadId)
    {
        return AjaxResult.success(erpAccountHeadService.selectErpAccountHeadById(accountHeadId));
    }

    /**
     * 新增收入单
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:add')")
    @Log(title = "收入单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpAccountHead erpAccountHead)
    {
        return toAjax(erpAccountHeadService.insertErpAccountHead(erpAccountHead));
    }

    /**
     * 修改收入单
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:edit')")
    @Log(title = "收入单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpAccountHead erpAccountHead)
    {
        return toAjax(erpAccountHeadService.updateErpAccountHead(erpAccountHead));
    }

    /**
     * 删除收入单
     */
    @PreAuthorize("@ss.hasPermi('financial:itemin:remove')")
    @Log(title = "收入单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{accountHeadIds}")
    public AjaxResult remove(@PathVariable Long[] accountHeadIds)
    {
        return toAjax(erpAccountHeadService.deleteErpAccountHeadByIds(accountHeadIds));
    }
}
