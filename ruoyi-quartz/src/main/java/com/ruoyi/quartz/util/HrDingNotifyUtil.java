package com.ruoyi.quartz.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

public class HrDingNotifyUtil {

    /*
    * @Description: 发送钉钉机器人提醒消息
    * @Param: content 发送的文本内容
    * @return: void
    */
    public static void sendNotify(String content) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=95053e541d696ee46e68414a21740d7980080a6fec8cbeb64c79bd1e1f354791");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        OapiRobotSendResponse response = client.execute(request);
    }

}
