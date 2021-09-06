package com.sdb.scm.purchase.controller;

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
import com.sdb.scm.purchase.domain.ErpJxcHead;
import com.sdb.scm.purchase.service.IErpJxcHeadService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 采购订单Controller
 * 
 * @author jzg
 * @date 2021-08-17
 */
@RestController
@RequestMapping("/purchase/purchaseorder")
public class ErpJxcHeadController extends BaseController
{
    @Autowired
    private IErpJxcHeadService erpJxcHeadService;

    /**
     * 查询采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpJxcHead erpJxcHead)
    {
        startPage();
        List<ErpJxcHead> list = erpJxcHeadService.selectErpJxcHeadList(erpJxcHead);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:export')")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpJxcHead erpJxcHead)
    {
        List<ErpJxcHead> list = erpJxcHeadService.selectErpJxcHeadList(erpJxcHead);
        ExcelUtil<ErpJxcHead> util = new ExcelUtil<ErpJxcHead>(ErpJxcHead.class);
        return util.exportExcel(list, "采购订单数据");
    }

    /**
     * 获取采购订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:query')")
    @GetMapping(value = "/{jxcHeadId}")
    public AjaxResult getInfo(@PathVariable("jxcHeadId") Long jxcHeadId)
    {
        return AjaxResult.success(erpJxcHeadService.selectErpJxcHeadById(jxcHeadId));
    }

    /**
     * 新增采购订单
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:add')")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpJxcHead erpJxcHead)
    {
        return toAjax(erpJxcHeadService.insertErpJxcHead(erpJxcHead));
    }

    /**
     * 修改采购订单
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:edit')")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpJxcHead erpJxcHead)
    {
        return toAjax(erpJxcHeadService.updateErpJxcHead(erpJxcHead));
    }

    /**
     * 删除采购订单
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseorder:remove')")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jxcHeadIds}")
    public AjaxResult remove(@PathVariable Long[] jxcHeadIds)
    {
        return toAjax(erpJxcHeadService.deleteErpJxcHeadByIds(jxcHeadIds));
    }
}
