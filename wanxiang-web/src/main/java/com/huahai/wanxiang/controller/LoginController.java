package com.huahai.wanxiang.controller;

import com.huahai.wanxiang.dao.domain.UserInfoDO;
import com.huahai.wanxiang.params.LoginParam;
import com.huahai.wanxiang.response.ResultVO;
import com.huahai.wanxiang.service.constants.CommonConstants;
import com.huahai.wanxiang.service.context.UserContext;
import com.huahai.wanxiang.service.service.UserService;
import com.huahai.wanxiang.service.util.DesUtil;
import com.huahai.wanxiang.service.util.UrlUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import java.util.Objects;

@RestController
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;
    @Value("${wanxiang.domain}")
    private String domain;

    @PostMapping("login")
    public ResultVO<Boolean> login(@RequestBody LoginParam loginParam) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        ResultVO<Boolean> resultVO = new ResultVO<>();
        if (StringUtils.isBlank(loginParam.getUsername())) {
            resultVO.setFail("用户名不对");
        }
        if (StringUtils.isBlank(loginParam.getPassword())) {
            resultVO.setFail("密码不对");
        }
        UserInfoDO userInfoDO = userService.getUserByPassWord(loginParam.getUsername(),loginParam.getPassword());
        if (Objects.isNull(userInfoDO)) {
            resultVO.setFail("没有此用户");
            return resultVO;
        }
        UserContext.set(userInfoDO);
        if (Objects.nonNull(userInfoDO)) {
            try {
                String userIdCiper = DesUtil.encryptByDES(userInfoDO.getId().toString(),DesUtil.SECRET);
                Cookie userId = new Cookie(CommonConstants.SSO_TOKEN,userIdCiper);
                userId.setPath("/");
                userId.setMaxAge(86400);
                if (StringUtils.isBlank(domain)) {
                    userId.setDomain(UrlUtil.getTopDomain(attributes.getRequest().getRequestURL().toString()));
                } else {
                    userId.setDomain(domain);
                }
                attributes.getResponse().addCookie(userId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        resultVO.setSuccessData(true);
        return resultVO;
    }

    @GetMapping("logout")
    public ResultVO<Boolean> logout() {
        ResultVO<Boolean> resultVO = new ResultVO<>();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Cookie userId = new Cookie(CommonConstants.SSO_TOKEN,"");
        userId.setMaxAge(0);
        attributes.getResponse().addCookie(userId);
        resultVO.setSuccessData(true);
        return resultVO;
    }
}
