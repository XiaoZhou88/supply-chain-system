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
import com.sdb.scm.base.domain.ErpAccount;
import com.sdb.scm.base.service.IErpAccountService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 账户信息Controller
 * 
 * @author sdb
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/base/account")
public class ErpAccountController extends BaseController
{
    @Autowired
    private IErpAccountService erpAccountService;

    /**
     * 查询账户信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpAccount erpAccount)
    {
        startPage();
        List<ErpAccount> list = erpAccountService.selectErpAccountList(erpAccount);
        return getDataTable(list);
    }

    /**
     * 导出账户信息列表
     */
    @PreAuthorize("@ss.hasPermi('base:account:export')")
    @Log(title = "账户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpAccount erpAccount)
    {
        List<ErpAccount> list = erpAccountService.selectErpAccountList(erpAccount);
        ExcelUtil<ErpAccount> util = new ExcelUtil<ErpAccount>(ErpAccount.class);
        return util.exportExcel(list, "账户信息数据");
    }

    /**
     * 获取账户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:account:query')")
    @GetMapping(value = "/{accountId}")
    public AjaxResult getInfo(@PathVariable("accountId") Long accountId)
    {
        return AjaxResult.success(erpAccountService.selectErpAccountById(accountId));
    }

    /**
     * 新增账户信息
     */
    @PreAuthorize("@ss.hasPermi('base:account:add')")
    @Log(title = "账户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpAccount erpAccount)
    {
        return toAjax(erpAccountService.insertErpAccount(erpAccount));
    }

    /**
     * 修改账户信息
     */
    @PreAuthorize("@ss.hasPermi('base:account:edit')")
    @Log(title = "账户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpAccount erpAccount)
    {
        return toAjax(erpAccountService.updateErpAccount(erpAccount));
    }

    /**
     * 删除账户信息
     */
    @PreAuthorize("@ss.hasPermi('base:account:remove')")
    @Log(title = "账户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{accountIds}")
    public AjaxResult remove(@PathVariable Long[] accountIds)
    {
        return toAjax(erpAccountService.deleteErpAccountByIds(accountIds));
    }
}
