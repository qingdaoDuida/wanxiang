package com.huahai.wanxiang.interceptor;

import com.huahai.wanxiang.dao.domain.TenantInfoDO;
import com.huahai.wanxiang.service.context.TenantContext;
import com.huahai.wanxiang.service.context.UserContext;
import com.huahai.wanxiang.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long userId = UserContext.get().getId();
        TenantInfoDO tenantInfoDO = userService.getTenantByUserId(userId);
        TenantContext.set(tenantInfoDO);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
