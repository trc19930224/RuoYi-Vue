package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.quartz.domain.HrBaseResponse;
import com.ruoyi.quartz.domain.HrShop;
import com.ruoyi.quartz.service.IHrCityService;
import com.ruoyi.quartz.service.IHrShopService;
import com.ruoyi.system.domain.HrCity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("HrShopTask")
public class HrShopTask {

    @Autowired
    IHrCityService cityService;

    @Autowired
    IHrShopService shopService;

    @Autowired
    OkHttpClient client;

    @Value("${requestUrl.getShopsInfo}")
    private String getShopsInfoUrl;

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

}
