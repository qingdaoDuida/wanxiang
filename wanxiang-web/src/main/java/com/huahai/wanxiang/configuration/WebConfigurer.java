package com.huahai.wanxiang.configuration;

import com.huahai.wanxiang.interceptor.LoginInterceptor;
import com.huahai.wanxiang.interceptor.TenantInterceptor;
import com.huahai.wanxiang.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private UserInterceptor userInterceptor;
    @Autowired
    private TenantInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).
                excludePathPatterns("/error").
                excludePathPatterns("/spider/*").
                excludePathPatterns("/login/login");
        registry.addInterceptor(userInterceptor).
                excludePathPatterns("/error").
                excludePathPatterns("/spider/*").
                excludePathPatterns("/login/*");
        registry.addInterceptor(tenantInterceptor).
                excludePathPatterns("/error").
                excludePathPatterns("/spider/*").
                excludePathPatterns("/login/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
