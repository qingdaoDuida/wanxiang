package com.huahai.wanxiang.service.service;

import com.github.pagehelper.PageInfo;
import com.huahai.wanxiang.service.dto.ArticleInfoDTO;

import java.util.List;

public interface ArticleService {

    PageInfo<ArticleInfoDTO> list(Integer pageNo,Integer pageSize);

    PageInfo<ArticleInfoDTO> query(String shopeeId,Integer pageNo,Integer pageSize);

    ArticleInfoDTO queryById(Long id);

    List<ArticleInfoDTO> getArticleByIdList(List<Long> idList);
}
