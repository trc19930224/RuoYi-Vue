package com.ruoyi.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.quartz.mapper.HrUserMapper;
import com.ruoyi.quartz.domain.HrUser;
import com.ruoyi.quartz.service.IHrUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
@Service
public class HrUserServiceImpl implements IHrUserService 
{
    @Autowired
    private HrUserMapper hrUserMapper;

    /**
     * 查询用户信息
     * 
     * @param mobile 用户信息ID
     * @return 用户信息
     */
    @Override
    public HrUser selectHrUserById(String mobile)
    {
        return hrUserMapper.selectHrUserById(mobile);
    }

    /**
     * 查询用户信息列表
     * 
     * @param hrUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<HrUser> selectHrUserList(HrUser hrUser)
    {
        return hrUserMapper.selectHrUserList(hrUser);
    }

    /**
     * 新增用户信息
     * 
     * @param hrUser 用户信息
     * @return 结果
     */
    @Override
    public int insertHrUser(HrUser hrUser)
    {
        return hrUserMapper.insertHrUser(hrUser);
    }

    /**
     * 修改用户信息
     * 
     * @param hrUser 用户信息
     * @return 结果
     */
    @Override
    public int updateHrUser(HrUser hrUser)
    {
        return hrUserMapper.updateHrUser(hrUser);
    }

    /**
     * 批量删除用户信息
     * 
     * @param mobiles 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteHrUserByIds(String[] mobiles)
    {
        return hrUserMapper.deleteHrUserByIds(mobiles);
    }

    /**
     * 删除用户信息信息
     * 
     * @param mobile 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteHrUserById(String mobile)
    {
        return hrUserMapper.deleteHrUserById(mobile);
    }
}
