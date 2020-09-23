package com.ruoyi.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.quartz.mapper.HrShopMapper;
import com.ruoyi.quartz.domain.HrShop;
import com.ruoyi.quartz.service.IHrShopService;

/**
 * 门店列Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
@Service
public class HrShopServiceImpl implements IHrShopService 
{
    @Autowired
    private HrShopMapper hrShopMapper;

    /**
     * 查询门店列
     * 
     * @param code 门店列ID
     * @return 门店列
     */
    @Override
    public HrShop selectHrShopById(String code)
    {
        return hrShopMapper.selectHrShopById(code);
    }

    /**
     * 查询门店列列表
     * 
     * @param hrShop 门店列
     * @return 门店列
     */
    @Override
    public List<HrShop> selectHrShopList(HrShop hrShop)
    {
        return hrShopMapper.selectHrShopList(hrShop);
    }

    /**
     * 新增门店列
     * 
     * @param hrShop 门店列
     * @return 结果
     */
    @Override
    public int insertHrShop(HrShop hrShop)
    {
        return hrShopMapper.insertHrShop(hrShop);
    }

    /**
     * 修改门店列
     * 
     * @param hrShop 门店列
     * @return 结果
     */
    @Override
    public int updateHrShop(HrShop hrShop)
    {
        return hrShopMapper.updateHrShop(hrShop);
    }

    /**
     * 批量删除门店列
     * 
     * @param codes 需要删除的门店列ID
     * @return 结果
     */
    @Override
    public int deleteHrShopByIds(String[] codes)
    {
        return hrShopMapper.deleteHrShopByIds(codes);
    }

    /**
     * 删除门店列信息
     * 
     * @param code 门店列ID
     * @return 结果
     */
    @Override
    public int deleteHrShopById(String code)
    {
        return hrShopMapper.deleteHrShopById(code);
    }
}
