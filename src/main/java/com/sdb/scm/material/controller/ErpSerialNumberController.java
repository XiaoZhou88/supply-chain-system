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
import com.sdb.scm.material.domain.ErpSerialNumber;
import com.sdb.scm.material.service.IErpSerialNumberService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 序列号Controller
 * 
 * @author jzg
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/material/serialnumber")
public class ErpSerialNumberController extends BaseController
{
    @Autowired
    private IErpSerialNumberService erpSerialNumberService;

    /**
     * 查询序列号列表
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpSerialNumber erpSerialNumber)
    {
        startPage();
        List<ErpSerialNumber> list = erpSerialNumberService.selectErpSerialNumberList(erpSerialNumber);
        return getDataTable(list);
    }

    /**
     * 导出序列号列表
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:export')")
    @Log(title = "序列号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpSerialNumber erpSerialNumber)
    {
        List<ErpSerialNumber> list = erpSerialNumberService.selectErpSerialNumberList(erpSerialNumber);
        ExcelUtil<ErpSerialNumber> util = new ExcelUtil<ErpSerialNumber>(ErpSerialNumber.class);
        return util.exportExcel(list, "序列号数据");
    }

    /**
     * 获取序列号详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:query')")
    @GetMapping(value = "/{serialId}")
    public AjaxResult getInfo(@PathVariable("serialId") Long serialId)
    {
        return AjaxResult.success(erpSerialNumberService.selectErpSerialNumberById(serialId));
    }

    /**
     * 新增序列号
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:add')")
    @Log(title = "序列号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpSerialNumber erpSerialNumber)
    {
        return toAjax(erpSerialNumberService.insertErpSerialNumber(erpSerialNumber));
    }

    /**
     * 修改序列号
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:edit')")
    @Log(title = "序列号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpSerialNumber erpSerialNumber)
    {
        return toAjax(erpSerialNumberService.updateErpSerialNumber(erpSerialNumber));
    }

    /**
     * 删除序列号
     */
    @PreAuthorize("@ss.hasPermi('material:serialnumber:remove')")
    @Log(title = "序列号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{serialIds}")
    public AjaxResult remove(@PathVariable Long[] serialIds)
    {
        return toAjax(erpSerialNumberService.deleteErpSerialNumberByIds(serialIds));
    }
}
