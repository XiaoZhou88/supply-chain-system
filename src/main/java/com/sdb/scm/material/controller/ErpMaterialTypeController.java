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
import com.sdb.scm.material.domain.ErpMaterialType;
import com.sdb.scm.material.service.IErpMaterialTypeService;
import com.sdb.base.utils.poi.ExcelUtil;

/**
 * 商品类型Controller
 * 
 * @author sdb
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/material/materialtype")
public class ErpMaterialTypeController extends BaseController
{
    @Autowired
    private IErpMaterialTypeService erpMaterialTypeService;

    /**
     * 查询商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:list')")
    @GetMapping("/list")
    public AjaxResult list(ErpMaterialType erpMaterialType)
    {
        List<ErpMaterialType> list = erpMaterialTypeService.selectErpMaterialTypeList(erpMaterialType);
        return AjaxResult.success(list);
    }

    /**
     * 导出商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:export')")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpMaterialType erpMaterialType)
    {
        List<ErpMaterialType> list = erpMaterialTypeService.selectErpMaterialTypeList(erpMaterialType);
        ExcelUtil<ErpMaterialType> util = new ExcelUtil<ErpMaterialType>(ErpMaterialType.class);
        return util.exportExcel(list, "商品类型数据");
    }

    /**
     * 获取商品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:query')")
    @GetMapping(value = "/{materialTypeId}")
    public AjaxResult getInfo(@PathVariable("materialTypeId") Long materialTypeId)
    {
        return AjaxResult.success(erpMaterialTypeService.selectErpMaterialTypeById(materialTypeId));
    }

    /**
     * 新增商品类型
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:add')")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpMaterialType erpMaterialType)
    {
        return toAjax(erpMaterialTypeService.insertErpMaterialType(erpMaterialType));
    }

    /**
     * 修改商品类型
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:edit')")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpMaterialType erpMaterialType)
    {
        return toAjax(erpMaterialTypeService.updateErpMaterialType(erpMaterialType));
    }

    /**
     * 删除商品类型
     */
    @PreAuthorize("@ss.hasPermi('material:materialtype:remove')")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialTypeIds}")
    public AjaxResult remove(@PathVariable Long[] materialTypeIds)
    {
        return toAjax(erpMaterialTypeService.deleteErpMaterialTypeByIds(materialTypeIds));
    }
}
