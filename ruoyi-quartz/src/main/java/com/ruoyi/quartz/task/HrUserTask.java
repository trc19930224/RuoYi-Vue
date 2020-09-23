package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.quartz.domain.HrBaseResponse;
import com.ruoyi.quartz.domain.HrUser;
import com.ruoyi.quartz.domain.HrUserSession;
import com.ruoyi.quartz.service.IHrUserService;
import com.ruoyi.quartz.util.RSAUtil;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("HrUserTask")
public class HrUserTask {

    private static final Logger log = LoggerFactory.getLogger(HrUserTask.class);

    @Autowired
    IHrUserService userService;

    @Autowired
    OkHttpClient client;

    @Value("${requestUrl.login}")
    private String loginUrl;

    @Value("${requestUrl.userInfo}")
    private String userInfoUrl;

    @Value("${rsa.publicKey}")
    private String publicKey;

    /*
    * @Description: 插入用户
    * @Param: mobile 用户手机号
    * @Param: password 用户密码
    * @Param: isOrder 是否为下单用户
    * @return: void
    */
    public void insertUserInfo(String mobile, String password, Integer isOrder) {
        HrUser user = new HrUser();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setIsOrder(isOrder);
        userService.insertHrUser(user);
        System.out.println("用户新增成功");
    }

    /*
    * @Description: 更新单个用户的信息
    * @Param: mobile 用户手机号
    * @return: void
    */
    public void updateUserInfo(String mobile) throws Exception {
        HrUser user = userService.selectHrUserById(mobile);
        Map<String, String> param = new HashMap<String, String>();
        param.put("loginName", mobile);
        param.put("password", RSAUtil.encrypt(user.getPassword(), publicKey));
        Request sessionRequest = new Request.Builder()
                .url(loginUrl + "?param=" + URLEncoder.encode(JSON.toJSONString(param),"UTF-8"))
                .post(RequestBody.create(MediaType.parse("text/plain"), ""))
                .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                .build();
        Response sessionResponse = client.newCall(sessionRequest).execute();
        HrBaseResponse<HrUserSession> sessionModel = JSON.parseObject(sessionResponse.body().string(), new TypeReference<HrBaseResponse<HrUserSession>>() {});
        if (sessionModel.getStateCode() == 0) {
            Request userRequest = new Request.Builder()
                    .url(userInfoUrl)
                    .post(RequestBody.create(MediaType.parse("text/plain"), ""))
                    .addHeader("unique", "ios-1876A11C-7173-4F8F-899E-110F7FDF38D8")
                    .addHeader("userSession",sessionModel.getData().getUserSession())
                    .build();
            Response userResponse = client.newCall(userRequest).execute();
            HrBaseResponse<HrUser> userModel = JSON.parseObject(userResponse.body().string(), new TypeReference<HrBaseResponse<HrUser>>() {});
            HrUser newUser = userModel.getData();
            newUser.setUserSession(sessionModel.getData().getUserSession());
            newUser.setPassword(user.getPassword());
            newUser.setIsOrder(user.getIsOrder());
            userService.updateHrUser(newUser);
            log.info("用户:" + user.getMobile() + "更新成功");
        } else {
            log.error(sessionModel.getMessage());
        }
    }

    /*
    * @Description: 更新所有的用户信息
    * @Param:
    * @return:
    */
    public void updateAllUserInfo() throws Exception {
        List<HrUser> userList = userService.selectHrUserList(null);
        for (HrUser user: userList) {
            updateUserInfo(user.getMobile());
        }
    }

}
