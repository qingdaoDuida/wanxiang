package com.huahai.wanxiang.service.context;

import com.huahai.wanxiang.dao.domain.UserInfoDO;

public class UserContext {

    private static ThreadLocal<UserInfoDO> threadLocal = new ThreadLocal<>();

    public static void set(UserInfoDO userInfoDO) {
        threadLocal.set(userInfoDO);
    }

    public static UserInfoDO get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
