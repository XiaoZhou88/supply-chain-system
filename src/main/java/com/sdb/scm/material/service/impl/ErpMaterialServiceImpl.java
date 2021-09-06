package com.sdb.scm.material.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.sdb.base.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.sdb.scm.material.domain.ErpExmaterial;
import com.sdb.scm.material.mapper.ErpMaterialMapper;
import com.sdb.scm.material.domain.ErpMaterial;
import com.sdb.scm.material.service.IErpMaterialService;

/**
 * 商品信息Service业务层处理
 * 
 * @author sdb
 * @date 2021-08-14
 */
@Service
public class ErpMaterialServiceImpl implements IErpMaterialService 
{
    @Autowired
    private ErpMaterialMapper erpMaterialMapper;

    /**
     * 查询商品信息
     * 
     * @param materialId 商品信息ID
     * @return 商品信息
     */
    @Override
    public ErpMaterial selectErpMaterialById(Long materialId)
    {
        return erpMaterialMapper.selectErpMaterialById(materialId);
    }

    /**
     * 查询商品信息列表
     * 
     * @param erpMaterial 商品信息
     * @return 商品信息
     */
    @Override
    public List<ErpMaterial> selectErpMaterialList(ErpMaterial erpMaterial)
    {
        return erpMaterialMapper.selectErpMaterialList(erpMaterial);
    }

    /**
     * 新增商品信息
     * 
     * @param erpMaterial 商品信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertErpMaterial(ErpMaterial erpMaterial)
    {
        int rows = erpMaterialMapper.insertErpMaterial(erpMaterial);
        insertErpExmaterial(erpMaterial);
        return rows;
    }

    /**
     * 修改商品信息
     * 
     * @param erpMaterial 商品信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateErpMaterial(ErpMaterial erpMaterial)
    {
        erpMaterialMapper.deleteErpExmaterialByMaterialId(erpMaterial.getMaterialId());
        insertErpExmaterial(erpMaterial);
        return erpMaterialMapper.updateErpMaterial(erpMaterial);
    }

    /**
     * 批量删除商品信息
     * 
     * @param materialIds 需要删除的商品信息ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteErpMaterialByIds(Long[] materialIds)
    {
        erpMaterialMapper.deleteErpExmaterialByMaterialIds(materialIds);
        return erpMaterialMapper.deleteErpMaterialByIds(materialIds);
    }

    /**
     * 删除商品信息信息
     * 
     * @param materialId 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteErpMaterialById(Long materialId)
    {
        erpMaterialMapper.deleteErpExmaterialByMaterialId(materialId);
        return erpMaterialMapper.deleteErpMaterialById(materialId);
    }

    /**
     * 新增商品扩展信息信息
     * 
     * @param erpMaterial 商品信息对象
     */
    public void insertErpExmaterial(ErpMaterial erpMaterial)
    {
        List<ErpExmaterial> erpExmaterialList = erpMaterial.getErpExmaterialList();
        Long materialId = erpMaterial.getMaterialId();
        if (StringUtils.isNotNull(erpExmaterialList))
        {
            List<ErpExmaterial> list = new ArrayList<ErpExmaterial>();
            for (ErpExmaterial erpExmaterial : erpExmaterialList)
            {
                erpExmaterial.setMaterialId(materialId);
                list.add(erpExmaterial);
            }
            if (list.size() > 0)
            {
                erpMaterialMapper.batchErpExmaterial(list);
            }
        }
    }
}
