package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.quartz.domain.*;
import com.ruoyi.quartz.service.IHrShopService;
import com.ruoyi.quartz.service.IHrUserService;
import com.ruoyi.quartz.util.HrDingNotifyUtil;
import com.ruoyi.quartz.util.RSAUtil;
import com.taobao.api.ApiException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component("HrStockTask")
public class HrStockTask {

    private static final Logger log = LoggerFactory.getLogger(HrStockTask.class);

    @Autowired
    OkHttpClient client;

    @Autowired
    IHrUserService userService;

    @Autowired
    IHrShopService shopService;

    @Autowired
    HrUserTask userTask;

    @Value("${requestUrl.getProductInfo}")
    private String productInfoUrl;

    /*
    * @Description: 查询门店库存
    * @Param: mobile 手机号
    * @Param: shopCode 门店id
    * @return: void
    */
    public void queryStock(String mobile, String shopCode) throws IOException, ApiException {
        HrUser user = userService.selectHrUserById(mobile);
        if (user.getIsBlocked() == 1) {return;} // 账户拉黑状态下不再发起请求
        Map<String, String> param = new HashMap<String, String>();
        param.put("activityId", "2");
        param.put("shopCode", shopCode);
        Request productsRequest = new Request.Builder()
                .url(productInfoUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .get()
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .addHeader("userSession",user.getUserSession())
                .build();
        Response productsResponse = client.newCall(productsRequest).execute();
        HrBaseResponse<HrShopProducts> productsModel = JSON.parseObject(productsResponse.body().string(), new TypeReference<HrBaseResponse<HrShopProducts>>() {});
        if (productsModel.getStateCode() == 0) {
            log.info("请求成功次数+1");
            for (HrProduct product: productsModel.getData().getProducts()) {
                if ((product.getStock() >= 6) && (product.getProductId().equals("230037") || product.getProductId().equals("195731") || product.getProductId().equals("195730"))) {
                    // 满足下单条件

                }
            }
        } else {
            if (productsModel.getStateCode() == 2) {
                // 当前这个号被黑
                user.setIsBlocked(1);
                userService.updateHrUser(user);
                log.error(mobile + "账号被拉黑");
                HrDingNotifyUtil.sendNotify(mobile + "账号被拉黑");
            } else if (productsModel.getStateCode() == 3) {
                log.error(mobile + ":账号尚未登录");
                try {
                    userTask.updateUserInfo(user.getMobile());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void queryFocusStockInfo() {
        // 查询需要监控的所有门店信息
        List<HrShop> shopList = shopService.selectHrShopList(new HrShop(1));
        log.info("当前监控的门店数量为:"+ shopList.size());
        // 查询出可扫描的账号数量
        List<HrUser> userList = userService.selectHrUserList(new HrUser(0));
        log.info("可扫描的账户数量为:"+ userList.size());
    }

}
