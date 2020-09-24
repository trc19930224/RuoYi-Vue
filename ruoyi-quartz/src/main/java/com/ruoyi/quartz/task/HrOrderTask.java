package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.quartz.domain.*;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Component("HrOrderTask")
public class HrOrderTask {

    private static final Logger log = LoggerFactory.getLogger(HrOrderTask.class);

    @Autowired
    OkHttpClient client;

    @Value("${requestUrl.addCart}")
    private String addCartUrl;

    @Value("${requestUrl.preSale}")
    private String preSaleUrl;

    @Value("${requestUrl.placeOrder}")
    private String placeOrderUrl;

    /*
    * @Description: 添加到购物车
    * @Param: user 下单的用户信息
    * @Param: product 下单的商品信息
    * @Param: number 下单数量
    * @return:
    */
    public void addCart(HrUser user, HrProduct product, Integer number) throws IOException {
        Map<String, String> param = new HashMap<String, String>();
        param.put("activityId", "2");
        param.put("presaleRuleId", product.getRuleId().toString());
        param.put("goodsId", product.getGoodsId().toString());
        param.put("productId", product.getProductId().toString());
        param.put("ncmsMemberId", user.getNcmsMemberId());
        param.put("mobile", user.getMobile());
        param.put("number", number.toString());
        Request cartRequest = new Request.Builder()
                .url(addCartUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .get()
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .addHeader("userSession",user.getUserSession())
                .build();
        Response cartResponse = client.newCall(cartRequest).execute();
        HrBaseResponse<HrCart> cartModel = JSON.parseObject(cartResponse.body().toString(), new TypeReference<HrBaseResponse<HrCart>>() {});
        if (cartModel.getStateCode() == 0) {
            if (cartModel.getData().getResult()) {
                // 添加购物车成功，开始下一步预下单
            } else {
                log.info(user.getMobile() + "添加购物车失败:" + cartModel.getData().getTip());
            }
        } else {
            log.info(user.getMobile() + "添加购物车失败:" + cartModel.getMessage());
        }
    }

    /*
    * @Description: 商品预下单
     * @Param: user 下单的用户信息
     * @Param: product 下单的商品信息
    * @return: void
    */
    public void preSale(HrUser user, HrProduct product) throws IOException {
        Map<String, String> param = new HashMap<String, String>();
        param.put("presaleRuleId", product.getRuleId().toString());
        param.put("subsiteId", product.getSubsiteId().toString());

        Request preSaleRequest = new Request.Builder()
                .url(preSaleUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .post(RequestBody.create(MediaType.parse("text/plain"), ""))
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .addHeader("userSession",user.getUserSession())
                .build();
        Response preSaleResponse = client.newCall(preSaleRequest).execute();
        HrBaseResponse<HrPreSale> preSaleModel = JSON.parseObject(preSaleResponse.body().toString(), new TypeReference<HrBaseResponse<HrPreSale>>() {});
        if (preSaleModel.getStateCode() == 0) {

        } else {
            log.info(user.getMobile() + "预下单失败:" + preSaleModel.getMessage());
        }
    }

    /*
    * @Description: 商品最终下单
    * @Param: token 商品预下单时返回的token
    * @Param: user 下单的用户信息
    * @Param: product 下单的商品信息
    * @return:
    */
    public void placeOrder(String token, HrUser user, HrProduct product) throws IOException {
        Map<String, String> param = new HashMap<String, String>();
        param.put("token", token);
        param.put("paymentModeType", "1");
        param.put("subsiteId", product.getSubsiteId().toString());
        param.put("goodsId", product.getGoodsId().toString());
        param.put("presaleRuleId", product.getRuleId().toString());

        Request placeOrderRequest = new Request.Builder()
                .url(preSaleUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .post(RequestBody.create(MediaType.parse("text/plain"), ""))
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .addHeader("userSession",user.getUserSession())
                .build();
        Response placeOrderResponse = client.newCall(placeOrderRequest).execute();
        log.info(placeOrderResponse.body().toString());
//        HrBaseResponse<HrPreSale> placeOrderModel = JSON.parseObject(placeOrderResponse.body().toString(), new TypeReference<HrBaseResponse<HrPreSale>>() {});
//        if (placeOrderModel.getStateCode() == 0) {
//            // 下单真正成功
//        } else {
//            log.info(user.getMobile() + "最终下单失败:" + placeOrderModel.getMessage());
//        }
    }

}
