package com.huahai.wanxiang.controller;

import com.huahai.wanxiang.params.SpiderByUrlParam;
import com.huahai.wanxiang.response.ResultVO;
import com.huahai.wanxiang.service.service.SpiderParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

@RestController
@RequestMapping("/spider/")
public class SpiderController {

    @Autowired
    private SpiderParseService alibabaDetailSpiderParseServiceImpl;

    @PostMapping("spiderByHtml")
    public ResultVO<Boolean> spiderByUrl(@RequestBody SpiderByUrlParam spiderByUrlParam) {
        ResultVO<Boolean> resultVO = new ResultVO<>();
        if (Objects.isNull(spiderByUrlParam.getTenantId())) {
            resultVO.setFail("非法请求");
            return resultVO;
        }

        try {
            alibabaDetailSpiderParseServiceImpl.parse(URLDecoder.decode(spiderByUrlParam.getHtml(),"UTF-8"),
                    URLDecoder.decode(spiderByUrlParam.getUrl(),"UTF-8"),spiderByUrlParam.getTenantId());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resultVO.setSuccessData(true);
        return resultVO;
    }
}
