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
import com.sdb.scm.base.domain.ErpAgent;
import com.sdb.scm.base.service.IErpAgentService;
import com.sdb.base.utils.poi.ExcelUtil;
import com.sdb.base.core.page.TableDataInfo;

/**
 * 经办人Controller
 * 
 * @author sdb
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/base/agent")
public class ErpAgentController extends BaseController
{
    @Autowired
    private IErpAgentService erpAgentService;

    /**
     * 查询经办人列表
     */
    @PreAuthorize("@ss.hasPermi('base:agent:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpAgent erpAgent)
    {
        startPage();
        List<ErpAgent> list = erpAgentService.selectErpAgentList(erpAgent);
        return getDataTable(list);
    }

    /**
     * 导出经办人列表
     */
    @PreAuthorize("@ss.hasPermi('base:agent:export')")
    @Log(title = "经办人", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpAgent erpAgent)
    {
        List<ErpAgent> list = erpAgentService.selectErpAgentList(erpAgent);
        ExcelUtil<ErpAgent> util = new ExcelUtil<ErpAgent>(ErpAgent.class);
        return util.exportExcel(list, "经办人数据");
    }

    /**
     * 获取经办人详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:agent:query')")
    @GetMapping(value = "/{agentId}")
    public AjaxResult getInfo(@PathVariable("agentId") Long agentId)
    {
        return AjaxResult.success(erpAgentService.selectErpAgentById(agentId));
    }

    /**
     * 新增经办人
     */
    @PreAuthorize("@ss.hasPermi('base:agent:add')")
    @Log(title = "经办人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpAgent erpAgent)
    {
        return toAjax(erpAgentService.insertErpAgent(erpAgent));
    }

    /**
     * 修改经办人
     */
    @PreAuthorize("@ss.hasPermi('base:agent:edit')")
    @Log(title = "经办人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpAgent erpAgent)
    {
        return toAjax(erpAgentService.updateErpAgent(erpAgent));
    }

    /**
     * 删除经办人
     */
    @PreAuthorize("@ss.hasPermi('base:agent:remove')")
    @Log(title = "经办人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{agentIds}")
    public AjaxResult remove(@PathVariable Long[] agentIds)
    {
        return toAjax(erpAgentService.deleteErpAgentByIds(agentIds));
    }
}
