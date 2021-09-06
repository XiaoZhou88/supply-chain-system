package com.sdb.scm.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdb.scm.base.mapper.ErpAgentMapper;
import com.sdb.scm.base.domain.ErpAgent;
import com.sdb.scm.base.service.IErpAgentService;

/**
 * 经办人Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-14
 */
@Service
public class ErpAgentServiceImpl implements IErpAgentService 
{
    @Autowired
    private ErpAgentMapper erpAgentMapper;

    /**
     * 查询经办人
     * 
     * @param agentId 经办人ID
     * @return 经办人
     */
    @Override
    public ErpAgent selectErpAgentById(Long agentId)
    {
        return erpAgentMapper.selectErpAgentById(agentId);
    }

    /**
     * 查询经办人列表
     * 
     * @param erpAgent 经办人
     * @return 经办人
     */
    @Override
    public List<ErpAgent> selectErpAgentList(ErpAgent erpAgent)
    {
        return erpAgentMapper.selectErpAgentList(erpAgent);
    }

    /**
     * 新增经办人
     * 
     * @param erpAgent 经办人
     * @return 结果
     */
    @Override
    public int insertErpAgent(ErpAgent erpAgent)
    {
        return erpAgentMapper.insertErpAgent(erpAgent);
    }

    /**
     * 修改经办人
     * 
     * @param erpAgent 经办人
     * @return 结果
     */
    @Override
    public int updateErpAgent(ErpAgent erpAgent)
    {
        return erpAgentMapper.updateErpAgent(erpAgent);
    }

    /**
     * 批量删除经办人
     * 
     * @param agentIds 需要删除的经办人ID
     * @return 结果
     */
    @Override
    public int deleteErpAgentByIds(Long[] agentIds)
    {
        return erpAgentMapper.deleteErpAgentByIds(agentIds);
    }

    /**
     * 删除经办人信息
     * 
     * @param agentId 经办人ID
     * @return 结果
     */
    @Override
    public int deleteErpAgentById(Long agentId)
    {
        return erpAgentMapper.deleteErpAgentById(agentId);
    }
}
