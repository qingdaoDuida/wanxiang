package com.huahai.wanxiang.service.service;

import com.huahai.wanxiang.dao.domain.*;
import com.huahai.wanxiang.dao.mapper.TenantInfoMapper;
import com.huahai.wanxiang.dao.mapper.TenantMemberMapper;
import com.huahai.wanxiang.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TenantMemberMapper tenantMemberMapper;
    @Autowired
    private TenantInfoMapper tenantInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public TenantInfoDO getTenantByUserId(Long userId) {
        TenantMemberDOExample example = new TenantMemberDOExample();
        TenantMemberDOExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeletedEqualTo(false);
        List<TenantMemberDO> tenantMemberDOList = tenantMemberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tenantMemberDOList)) {
            return null;
        }
        TenantInfoDO tenantInfoDO = tenantInfoMapper.selectByPrimaryKey(tenantMemberDOList.get(0).getTenantId());
        return tenantInfoDO;
    }

    @Override
    public UserInfoDO getUserById(Long userId) {
        UserInfoDO userInfoDO = userInfoMapper.selectByPrimaryKey(userId);
        return userInfoDO;
    }

    @Override
    public UserInfoDO getUserByPassWord(String userName, String passWord) {
        UserInfoDOExample example = new UserInfoDOExample();
        UserInfoDOExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPassWordEqualTo(passWord);
        List<UserInfoDO> userInfoDOList = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userInfoDOList)) {
            return null;
        }
        return userInfoDOList.get(0);
    }
}
