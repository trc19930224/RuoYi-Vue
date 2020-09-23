package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市列对象 hr_city
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public class HrCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市id */
    private Integer cityId;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cityId", getCityId())
            .append("cityName", getCityName())
            .toString();
    }
}
