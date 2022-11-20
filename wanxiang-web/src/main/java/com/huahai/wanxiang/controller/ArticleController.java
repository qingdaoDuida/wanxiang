package com.huahai.wanxiang.controller;

import com.github.pagehelper.PageInfo;
import com.huahai.wanxiang.response.ResultVO;
import com.huahai.wanxiang.service.dto.ArticleInfoDTO;
import com.huahai.wanxiang.service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("list")
    public ResultVO<PageInfo<ArticleInfoDTO>> list(Integer pageNO,Integer pageSize) {
        ResultVO<PageInfo<ArticleInfoDTO>> resultVO = new ResultVO<>();
        if (Objects.isNull(pageNO)) {
            pageNO = 1;
        }
        if (Objects.isNull(pageSize)) {
            pageSize = 20;
        }
        PageInfo<ArticleInfoDTO> pageInfo = articleService.list(pageNO,pageSize);
        resultVO.setSuccessData(pageInfo);
        return resultVO;
    }

    @GetMapping("query")
    public ResultVO<PageInfo<ArticleInfoDTO>> query(String shopeeId,Integer pageNO,Integer pageSize) {
        ResultVO<PageInfo<ArticleInfoDTO>> resultVO = new ResultVO<>();
        PageInfo<ArticleInfoDTO> list = articleService.query(shopeeId,pageNO,pageSize);
        resultVO.setSuccessData(list);
        return resultVO;
    }

    @GetMapping("queryById")
    public ResultVO<ArticleInfoDTO> queryById(Long id) {
        ResultVO<ArticleInfoDTO> resultVO = new ResultVO<>();
        ArticleInfoDTO articleInfoDTO = articleService.queryById(id);
        resultVO.setSuccessData(articleInfoDTO);
        return resultVO;
    }
}
