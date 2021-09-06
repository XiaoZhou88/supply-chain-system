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
import com.sdb.scm.base.domain.ErpDeposit;
import com.sdb.scm.base.service.IErpDepositService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 仓库Controller
 * 
 * @author sdb
 * @date 2021-08-11
 */
@RestController
@RequestMapping("/base/deposit")
public class ErpDepositController extends BaseController
{
    @Autowired
    private IErpDepositService erpDepositService;

    /**
     * 查询仓库列表
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpDeposit erpDeposit)
    {
        startPage();
        List<ErpDeposit> list = erpDepositService.selectErpDepositList(erpDeposit);
        return getDataTable(list);
    }

    /**
     * 导出仓库列表
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:export')")
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpDeposit erpDeposit)
    {
        List<ErpDeposit> list = erpDepositService.selectErpDepositList(erpDeposit);
        ExcelUtil<ErpDeposit> util = new ExcelUtil<ErpDeposit>(ErpDeposit.class);
        return util.exportExcel(list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:query')")
    @GetMapping(value = "/{depositId}")
    public AjaxResult getInfo(@PathVariable("depositId") Long depositId)
    {
        return AjaxResult.success(erpDepositService.selectErpDepositById(depositId));
    }

    /**
     * 新增仓库
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:add')")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpDeposit erpDeposit)
    {
        return toAjax(erpDepositService.insertErpDeposit(erpDeposit));
    }

    /**
     * 修改仓库
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:edit')")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpDeposit erpDeposit)
    {
        return toAjax(erpDepositService.updateErpDeposit(erpDeposit));
    }

    /**
     * 删除仓库
     */
    @PreAuthorize("@ss.hasPermi('base:deposit:remove')")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{depositIds}")
    public AjaxResult remove(@PathVariable Long[] depositIds)
    {
        return toAjax(erpDepositService.deleteErpDepositByIds(depositIds));
    }
}
