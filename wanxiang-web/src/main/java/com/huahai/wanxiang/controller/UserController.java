package com.huahai.wanxiang.controller;

import com.huahai.wanxiang.dao.domain.UserInfoDO;
import com.huahai.wanxiang.response.ResultVO;
import com.huahai.wanxiang.service.context.UserContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("info")
    public ResultVO<UserInfoDO> getUserInfo() {
        ResultVO<UserInfoDO> resultVO = new ResultVO<>();
        resultVO.setSuccessData(UserContext.get());
        return resultVO;
    }
}
