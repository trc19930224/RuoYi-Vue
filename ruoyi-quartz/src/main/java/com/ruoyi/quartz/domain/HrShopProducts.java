package com.ruoyi.quartz.domain;

import com.ruoyi.system.domain.HrCity;

import java.util.List;

public class HrShopProducts {

    private String activityTime;

    private String bottomImage;

    private HrCity city;

    private boolean enabled;

    private List<HrProduct> products;

    private HrShop store;

    private String topImage;

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getBottomImage() {
        return bottomImage;
    }

    public void setBottomImage(String bottomImage) {
        this.bottomImage = bottomImage;
    }

    public HrCity getCity() {
        return city;
    }

    public void setCity(HrCity city) {
        this.city = city;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<HrProduct> getProducts() {
        return products;
    }

    public void setProducts(List<HrProduct> products) {
        this.products = products;
    }

    public HrShop getStore() {
        return store;
    }

    public void setStore(HrShop store) {
        this.store = store;
    }

    public String getTopImage() {
        return topImage;
    }

    public void setTopImage(String topImage) {
        this.topImage = topImage;
    }
}
