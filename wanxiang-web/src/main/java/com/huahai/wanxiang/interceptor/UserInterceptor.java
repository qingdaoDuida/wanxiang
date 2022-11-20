package com.huahai.wanxiang.interceptor;

import com.huahai.wanxiang.dao.domain.UserInfoDO;
import com.huahai.wanxiang.service.constants.CommonConstants;
import com.huahai.wanxiang.service.context.UserContext;
import com.huahai.wanxiang.service.service.UserService;
import com.huahai.wanxiang.service.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userIdStr = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (CommonConstants.SSO_TOKEN.equals(cookie.getName())) {
                userIdStr = cookie.getValue();
            }
        }
        Long userId = -1L;
        userId = Long.valueOf(DesUtil.decryptByDES(userIdStr,DesUtil.SECRET));
        UserInfoDO userInfoDO = userService.getUserById(userId);
        UserContext.set(userInfoDO);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
