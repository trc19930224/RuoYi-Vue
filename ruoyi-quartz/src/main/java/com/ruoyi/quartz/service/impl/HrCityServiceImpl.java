package com.ruoyi.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.quartz.mapper.HrCityMapper;
import com.ruoyi.system.domain.HrCity;
import com.ruoyi.quartz.service.IHrCityService;

/**
 * 城市列Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
@Service
public class HrCityServiceImpl implements IHrCityService 
{
    @Autowired
    private HrCityMapper hrCityMapper;

    /**
     * 查询城市列
     * 
     * @param cityId 城市列ID
     * @return 城市列
     */
    @Override
    public HrCity selectHrCityById(Integer cityId)
    {
        return hrCityMapper.selectHrCityById(cityId);
    }

    /**
     * 查询城市列列表
     * 
     * @param hrCity 城市列
     * @return 城市列
     */
    @Override
    public List<HrCity> selectHrCityList(HrCity hrCity)
    {
        return hrCityMapper.selectHrCityList(hrCity);
    }

    /**
     * 新增城市列
     * 
     * @param hrCity 城市列
     * @return 结果
     */
    @Override
    public int insertHrCity(HrCity hrCity)
    {
        return hrCityMapper.insertHrCity(hrCity);
    }

    /**
     * 修改城市列
     * 
     * @param hrCity 城市列
     * @return 结果
     */
    @Override
    public int updateHrCity(HrCity hrCity)
    {
        return hrCityMapper.updateHrCity(hrCity);
    }

    /**
     * 批量删除城市列
     * 
     * @param cityIds 需要删除的城市列ID
     * @return 结果
     */
    @Override
    public int deleteHrCityByIds(Integer[] cityIds)
    {
        return hrCityMapper.deleteHrCityByIds(cityIds);
    }

    /**
     * 删除城市列信息
     * 
     * @param cityId 城市列ID
     * @return 结果
     */
    @Override
    public int deleteHrCityById(Integer cityId)
    {
        return hrCityMapper.deleteHrCityById(cityId);
    }
}
