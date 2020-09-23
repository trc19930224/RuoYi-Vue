package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.quartz.domain.HrBaseResponse;
import com.ruoyi.quartz.domain.HrCityData;
import com.ruoyi.quartz.domain.HrShop;
import com.ruoyi.quartz.service.IHrCityService;
import com.ruoyi.quartz.service.IHrShopService;
import com.ruoyi.system.domain.HrCity;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component("HrCityTask")
public class HrCityTask {

    @Value("${requestUrl.getCityInfo}")
    private String getCityInfoUrl;

    @Value("${requestUrl.getShopsInfo}")
    private String getShopsInfoUrl;

    @Autowired
    OkHttpClient client;

    @Autowired
    IHrCityService cityService;

    @Autowired
    IHrShopService shopService;

    private String[] keys = new String[]{"B","C","D","G","H","J","K","L","M","N","Q","S","T","W","X","Y","Z"};

    // 获取所有参与活动的城市列表
    public void getActivityCityInfo(String activityId) throws IOException {
        Map<String, String> param = new HashMap<String, String>();
        param.put("activityId", activityId);
        Request cityRequest = new Request.Builder()
                .url(getCityInfoUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .get()
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .build();
        Response cityResponse = client.newCall(cityRequest).execute();
        HrBaseResponse<HrCityData> response = JSON.parseObject(cityResponse.body().string(), new TypeReference<HrBaseResponse<HrCityData>>(){});
        for (String key: keys) {
            HrCity[] citys = (HrCity[]) getFieldValueByName(key, response.getData());
            for (HrCity city: citys) {
                cityService.insertHrCity(city);
            }
        }
        System.out.println("参与活动的城市列表获取成功");
    }

    // 获取所有参与活动的门店信息
    public void getAllShopsInfo(String activityId) throws IOException {
        List<HrCity> citys = cityService.selectHrCityList(null);
        for (HrCity city: citys) {
            Map<String, String> param = new HashMap<String, String>();
            param.put("activityId", activityId);
            param.put("cityId", city.getCityId().toString());
            Request shopRequest = new Request.Builder()
                    .url(getShopsInfoUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                    .get()
                    .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                    .build();
            Response shopResponse = client.newCall(shopRequest).execute();
            HrBaseResponse<List<HrShop>> response = JSON.parseObject(shopResponse.body().string(), new TypeReference<HrBaseResponse<List<HrShop>>>(){});
            for (HrShop shop: response.getData()) {
                shopService.insertHrShop(shop);
            }
        }
        System.out.println("参与活动的门店列表获取成功");
    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
//            logger.error("获取属性值失败！" + e, e);
        }
        return null;
    }

}
