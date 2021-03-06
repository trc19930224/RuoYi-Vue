package com.ruoyi.quartz.service;

import java.util.List;
import com.ruoyi.quartz.domain.HrShop;

/**
 * 门店列Service接口
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public interface IHrShopService 
{
    /**
     * 查询门店列
     * 
     * @param code 门店列ID
     * @return 门店列
     */
    public HrShop selectHrShopById(String code);

    /**
     * 查询门店列列表
     * 
     * @param hrShop 门店列
     * @return 门店列集合
     */
    public List<HrShop> selectHrShopList(HrShop hrShop);

    /**
     * 新增门店列
     * 
     * @param hrShop 门店列
     * @return 结果
     */
    public int insertHrShop(HrShop hrShop);

    /**
     * 修改门店列
     * 
     * @param hrShop 门店列
     * @return 结果
     */
    public int updateHrShop(HrShop hrShop);

    /**
     * 批量删除门店列
     * 
     * @param codes 需要删除的门店列ID
     * @return 结果
     */
    public int deleteHrShopByIds(String[] codes);

    /**
     * 删除门店列信息
     * 
     * @param code 门店列ID
     * @return 结果
     */
    public int deleteHrShopById(String code);
}
