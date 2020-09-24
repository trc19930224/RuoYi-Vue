package com.ruoyi.quartz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门店列对象 hr_shop
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public class HrShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市id */
    @Excel(name = "城市id")
    private Integer cityId;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 门店id */
    private String code;

    /** 距离 */
    @Excel(name = "距离")
    private Long distance;

    /** $column.columnComment */
    @Excel(name = "距离")
    private String endTime;

    /** $column.columnComment */
    @Excel(name = "距离")
    private Double latitude;

    /** $column.columnComment */
    @Excel(name = "距离")
    private Double longitude;

    /** $column.columnComment */
    @Excel(name = "距离")
    private Long psId;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Long saleCount;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 门店名称 */
    @Excel(name = "门店名称")
    private String storeName;

    /** 门店地址 */
    @Excel(name = "门店地址")
    private String storesAddress;

    /** 是否扫描 */
    @Excel(name = "是否扫描")
    private Integer state;

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
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setDistance(Long distance) 
    {
        this.distance = distance;
    }

    public Long getDistance() 
    {
        return distance;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }
    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }
    public void setPsId(Long psId) 
    {
        this.psId = psId;
    }

    public Long getPsId() 
    {
        return psId;
    }
    public void setSaleCount(Long saleCount) 
    {
        this.saleCount = saleCount;
    }

    public Long getSaleCount() 
    {
        return saleCount;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setStoresAddress(String storesAddress) 
    {
        this.storesAddress = storesAddress;
    }

    public String getStoresAddress() 
    {
        return storesAddress;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }

    public HrShop() {
    }

    public HrShop(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cityId", getCityId())
            .append("cityName", getCityName())
            .append("code", getCode())
            .append("distance", getDistance())
            .append("endTime", getEndTime())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("psId", getPsId())
            .append("saleCount", getSaleCount())
            .append("startTime", getStartTime())
            .append("storeName", getStoreName())
            .append("storesAddress", getStoresAddress())
            .append("state", getState())
            .toString();
    }
}
