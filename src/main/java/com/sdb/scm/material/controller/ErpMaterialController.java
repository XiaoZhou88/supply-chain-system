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
import com.sdb.scm.material.domain.ErpMaterial;
import com.sdb.scm.material.service.IErpMaterialService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 商品信息Controller
 * 
 * @author sdb
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/material/materialinfo")
public class ErpMaterialController extends BaseController
{
    @Autowired
    private IErpMaterialService erpMaterialService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpMaterial erpMaterial)
    {
        startPage();
        List<ErpMaterial> list = erpMaterialService.selectErpMaterialList(erpMaterial);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpMaterial erpMaterial)
    {
        List<ErpMaterial> list = erpMaterialService.selectErpMaterialList(erpMaterial);
        ExcelUtil<ErpMaterial> util = new ExcelUtil<ErpMaterial>(ErpMaterial.class);
        return util.exportExcel(list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId)
    {
        return AjaxResult.success(erpMaterialService.selectErpMaterialById(materialId));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpMaterial erpMaterial)
    {
        return toAjax(erpMaterialService.insertErpMaterial(erpMaterial));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpMaterial erpMaterial)
    {
        return toAjax(erpMaterialService.updateErpMaterial(erpMaterial));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialinfo:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialIds}")
    public AjaxResult remove(@PathVariable Long[] materialIds)
    {
        return toAjax(erpMaterialService.deleteErpMaterialByIds(materialIds));
    }
}
