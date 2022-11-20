package com.huahai.wanxiang.service.context;

import com.huahai.wanxiang.dao.domain.TenantInfoDO;

public class TenantContext {

    private static ThreadLocal<TenantInfoDO> threadLocal = new ThreadLocal<>();

    public static void set(TenantInfoDO tenantInfoDO) {
        threadLocal.set(tenantInfoDO);
    }

    public static TenantInfoDO get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
