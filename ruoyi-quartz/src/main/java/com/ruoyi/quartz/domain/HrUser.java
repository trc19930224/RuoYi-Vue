package com.ruoyi.quartz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 hr_user
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public class HrUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Integer id;

    /** 用户手机号 */
    private String mobile;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String password;

    /** 用户token */
    @Excel(name = "用户token")
    private String userSession;

    /** 用户生日 */
    @Excel(name = "用户生日")
    private String birthday;

    /** 会员卡 */
    @Excel(name = "会员卡")
    private String idCard;

    /** 地区名称 */
    @Excel(name = "地区名称")
    private String regionName;

    /** $column.columnComment */
    @Excel(name = "地区名称")
    private Long pic;

    /** 会员卡号 */
    @Excel(name = "会员卡号")
    private String cardNo;

    /** $column.columnComment */
    @Excel(name = "会员卡号")
    private String unSendOrderCount;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;

    /** $column.columnComment */
    @Excel(name = "登录名")
    private String unReceiveOrderCount;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** $column.columnComment */
    @Excel(name = "昵称")
    private Long unPayOrderCount;

    /** 商店id */
    @Excel(name = "商店id")
    private String shopId;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Integer memberId;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Integer inquire;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String address;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String uname;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Integer sex;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Long collectCount;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Long unreadMessageCount;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Long unEvaluateOrderCount;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String zipcode;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String realName;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String regionId;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String clerkCode;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private Long accountBalance;

    /** $column.columnComment */
    @Excel(name = "商店id")
    private String ncmsMemberId;

    /** 是否下单用户 */
    @Excel(name = "是否下单用户")
    private Integer isOrder;

    /** 当前是否被拉黑 */
    @Excel(name = "当前是否被拉黑")
    private Integer isBlocked;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setUserSession(String userSession) 
    {
        this.userSession = userSession;
    }

    public String getUserSession() 
    {
        return userSession;
    }
    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }
    public void setPic(Long pic) 
    {
        this.pic = pic;
    }

    public Long getPic() 
    {
        return pic;
    }
    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getCardNo()
    {
        return cardNo;
    }
    public void setUnSendOrderCount(String unSendOrderCount) 
    {
        this.unSendOrderCount = unSendOrderCount;
    }

    public String getUnSendOrderCount() 
    {
        return unSendOrderCount;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setUnReceiveOrderCount(String unReceiveOrderCount) 
    {
        this.unReceiveOrderCount = unReceiveOrderCount;
    }

    public String getUnReceiveOrderCount() 
    {
        return unReceiveOrderCount;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setUnPayOrderCount(Long unPayOrderCount) 
    {
        this.unPayOrderCount = unPayOrderCount;
    }

    public Long getUnPayOrderCount() 
    {
        return unPayOrderCount;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setMemberId(Integer memberId) 
    {
        this.memberId = memberId;
    }

    public Integer getMemberId() 
    {
        return memberId;
    }
    public void setInquire(Integer inquire) 
    {
        this.inquire = inquire;
    }

    public Integer getInquire() 
    {
        return inquire;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setUname(String uname) 
    {
        this.uname = uname;
    }

    public String getUname() 
    {
        return uname;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setCollectCount(Long collectCount) 
    {
        this.collectCount = collectCount;
    }

    public Long getCollectCount() 
    {
        return collectCount;
    }
    public void setUnreadMessageCount(Long unreadMessageCount) 
    {
        this.unreadMessageCount = unreadMessageCount;
    }

    public Long getUnreadMessageCount() 
    {
        return unreadMessageCount;
    }
    public void setUnEvaluateOrderCount(Long unEvaluateOrderCount) 
    {
        this.unEvaluateOrderCount = unEvaluateOrderCount;
    }

    public Long getUnEvaluateOrderCount() 
    {
        return unEvaluateOrderCount;
    }
    public void setZipcode(String zipcode) 
    {
        this.zipcode = zipcode;
    }

    public String getZipcode() 
    {
        return zipcode;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setRegionId(String regionId) 
    {
        this.regionId = regionId;
    }

    public String getRegionId() 
    {
        return regionId;
    }
    public void setClerkCode(String clerkCode) 
    {
        this.clerkCode = clerkCode;
    }

    public String getClerkCode() 
    {
        return clerkCode;
    }
    public void setAccountBalance(Long accountBalance) 
    {
        this.accountBalance = accountBalance;
    }

    public Long getAccountBalance() 
    {
        return accountBalance;
    }
    public void setNcmsMemberId(String ncmsMemberId) 
    {
        this.ncmsMemberId = ncmsMemberId;
    }

    public String getNcmsMemberId() 
    {
        return ncmsMemberId;
    }
    public void setIsOrder(Integer isOrder) 
    {
        this.isOrder = isOrder;
    }

    public Integer getIsOrder() 
    {
        return isOrder;
    }

    public Integer getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Integer isBlocked) {
        this.isBlocked = isBlocked;
    }

    public HrUser() {
    }

    public HrUser(Integer isOrder) {
        this.isOrder = isOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mobile", getMobile())
            .append("password", getPassword())
            .append("userSession", getUserSession())
            .append("birthday", getBirthday())
            .append("idCard", getIdCard())
            .append("regionName", getRegionName())
            .append("pic", getPic())
            .append("cardNo", getCardNo())
            .append("unSendOrderCount", getUnSendOrderCount())
            .append("loginName", getLoginName())
            .append("unReceiveOrderCount", getUnReceiveOrderCount())
            .append("nickname", getNickname())
            .append("unPayOrderCount", getUnPayOrderCount())
            .append("shopId", getShopId())
            .append("memberId", getMemberId())
            .append("inquire", getInquire())
            .append("address", getAddress())
            .append("uname", getUname())
            .append("sex", getSex())
            .append("collectCount", getCollectCount())
            .append("unreadMessageCount", getUnreadMessageCount())
            .append("unEvaluateOrderCount", getUnEvaluateOrderCount())
            .append("zipcode", getZipcode())
            .append("realName", getRealName())
            .append("regionId", getRegionId())
            .append("clerkCode", getClerkCode())
            .append("accountBalance", getAccountBalance())
            .append("ncmsMemberId", getNcmsMemberId())
            .append("isOrder", getIsOrder())
            .append("isBlocked", getIsBlocked())
            .toString();
    }
}
