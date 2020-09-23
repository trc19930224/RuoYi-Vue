package com.ruoyi.quartz.mapper;

import java.util.List;
import com.ruoyi.system.domain.HrCity;

/**
 * 城市列Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public interface HrCityMapper 
{
    /**
     * 查询城市列
     * 
     * @param cityId 城市列ID
     * @return 城市列
     */
    public HrCity selectHrCityById(Integer cityId);

    /**
     * 查询城市列列表
     * 
     * @param hrCity 城市列
     * @return 城市列集合
     */
    public List<HrCity> selectHrCityList(HrCity hrCity);

    /**
     * 新增城市列
     * 
     * @param hrCity 城市列
     * @return 结果
     */
    public int insertHrCity(HrCity hrCity);

    /**
     * 修改城市列
     * 
     * @param hrCity 城市列
     * @return 结果
     */
    public int updateHrCity(HrCity hrCity);

    /**
     * 删除城市列
     * 
     * @param cityId 城市列ID
     * @return 结果
     */
    public int deleteHrCityById(Integer cityId);

    /**
     * 批量删除城市列
     * 
     * @param cityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHrCityByIds(Integer[] cityIds);
}
