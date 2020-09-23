package com.ruoyi.quartz.service;

import java.util.List;
import com.ruoyi.quartz.domain.HrUser;

/**
 * 用户信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public interface IHrUserService 
{
    /**
     * 查询用户信息
     * 
     * @param mobile 用户信息ID
     * @return 用户信息
     */
    public HrUser selectHrUserById(String mobile);

    /**
     * 查询用户信息列表
     * 
     * @param hrUser 用户信息
     * @return 用户信息集合
     */
    public List<HrUser> selectHrUserList(HrUser hrUser);

    /**
     * 新增用户信息
     * 
     * @param hrUser 用户信息
     * @return 结果
     */
    public int insertHrUser(HrUser hrUser);

    /**
     * 修改用户信息
     * 
     * @param hrUser 用户信息
     * @return 结果
     */
    public int updateHrUser(HrUser hrUser);

    /**
     * 批量删除用户信息
     * 
     * @param mobiles 需要删除的用户信息ID
     * @return 结果
     */
    public int deleteHrUserByIds(String[] mobiles);

    /**
     * 删除用户信息信息
     * 
     * @param mobile 用户信息ID
     * @return 结果
     */
    public int deleteHrUserById(String mobile);
}
