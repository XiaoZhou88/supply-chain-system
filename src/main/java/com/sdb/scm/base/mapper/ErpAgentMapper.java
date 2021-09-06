package com.sdb.scm.base.mapper;

import java.util.List;
import com.sdb.scm.base.domain.ErpAgent;

/**
 * 经办人Mapper接口
 * 
 * @author sdb
 * @date 2021-08-14
 */
public interface ErpAgentMapper 
{
    /**
     * 查询经办人
     * 
     * @param agentId 经办人ID
     * @return 经办人
     */
    public ErpAgent selectErpAgentById(Long agentId);

    /**
     * 查询经办人列表
     * 
     * @param erpAgent 经办人
     * @return 经办人集合
     */
    public List<ErpAgent> selectErpAgentList(ErpAgent erpAgent);

    /**
     * 新增经办人
     * 
     * @param erpAgent 经办人
     * @return 结果
     */
    public int insertErpAgent(ErpAgent erpAgent);

    /**
     * 修改经办人
     * 
     * @param erpAgent 经办人
     * @return 结果
     */
    public int updateErpAgent(ErpAgent erpAgent);

    /**
     * 删除经办人
     * 
     * @param agentId 经办人ID
     * @return 结果
     */
    public int deleteErpAgentById(Long agentId);

    /**
     * 批量删除经办人
     * 
     * @param agentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteErpAgentByIds(Long[] agentIds);
}
