package com.huahai.wanxiang.interceptor;

import com.huahai.wanxiang.service.constants.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${wanxiang.redirectUrl}")
    private String redirectUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = null;
        Cookie[] cookies = request.getCookies();
        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (CommonConstants.SSO_TOKEN.equals(cookie.getName())) {
                    userId = cookie.getValue();
                }
            }
        }
        if (StringUtils.isBlank(userId)) {
            response.sendRedirect(redirectUrl);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
