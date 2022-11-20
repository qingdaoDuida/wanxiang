package com.huahai.wanxiang.service.service;

import com.huahai.wanxiang.dao.domain.TenantInfoDO;
import com.huahai.wanxiang.dao.domain.UserInfoDO;

public interface UserService {

    TenantInfoDO getTenantByUserId(Long userId);

    UserInfoDO getUserById(Long userId);

    UserInfoDO getUserByPassWord(String userName,String passWord);
}
