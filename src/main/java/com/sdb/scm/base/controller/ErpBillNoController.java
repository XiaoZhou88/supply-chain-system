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
import com.sdb.scm.base.domain.ErpBillNo;
import com.sdb.scm.base.service.IErpBillNoService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 单据编号Controller
 * 
 * @author jzg
 * @date 2021-08-18
 */
@RestController
@RequestMapping("/base/billno")
public class ErpBillNoController extends BaseController
{
    @Autowired
    private IErpBillNoService erpBillNoService;

    /**
     * 查询单据编号列表
     */
    @PreAuthorize("@ss.hasPermi('base:billno:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpBillNo erpBillNo)
    {
        startPage();
        List<ErpBillNo> list = erpBillNoService.selectErpBillNoList(erpBillNo);
        return getDataTable(list);
    }

    /**
     * 导出单据编号列表
     */
    @PreAuthorize("@ss.hasPermi('base:billno:export')")
    @Log(title = "单据编号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpBillNo erpBillNo)
    {
        List<ErpBillNo> list = erpBillNoService.selectErpBillNoList(erpBillNo);
        ExcelUtil<ErpBillNo> util = new ExcelUtil<ErpBillNo>(ErpBillNo.class);
        return util.exportExcel(list, "单据编号数据");
    }

    /**
     * 获取单据编号详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:billno:query')")
    @GetMapping(value = "/{seqName}")
    public AjaxResult getInfo(@PathVariable("seqName") String seqName)
    {
        return AjaxResult.success(erpBillNoService.selectErpBillNoById(seqName));
    }

    /**
     * 新增单据编号
     */
    @PreAuthorize("@ss.hasPermi('base:billno:add')")
    @Log(title = "单据编号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpBillNo erpBillNo)
    {
        return toAjax(erpBillNoService.insertErpBillNo(erpBillNo));
    }

    /**
     * 修改单据编号
     */
    @PreAuthorize("@ss.hasPermi('base:billno:edit')")
    @Log(title = "单据编号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpBillNo erpBillNo)
    {
        return toAjax(erpBillNoService.updateErpBillNo(erpBillNo));
    }

    /**
     * 删除单据编号
     */
    @PreAuthorize("@ss.hasPermi('base:billno:remove')")
    @Log(title = "单据编号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{seqNames}")
    public AjaxResult remove(@PathVariable String[] seqNames)
    {
        return toAjax(erpBillNoService.deleteErpBillNoByIds(seqNames));
    }
}
