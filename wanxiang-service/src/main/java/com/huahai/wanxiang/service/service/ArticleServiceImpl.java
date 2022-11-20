package com.huahai.wanxiang.service.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.huahai.wanxiang.dao.domain.ArticleInfoDO;
import com.huahai.wanxiang.dao.domain.ArticleInfoDOExample;
import com.huahai.wanxiang.dao.mapper.ArticleInfoMapper;
import com.huahai.wanxiang.service.dto.ArticleInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Override
    public PageInfo<ArticleInfoDTO> list(Integer pageNo, Integer pageSize) {
        ArticleInfoDOExample example = new ArticleInfoDOExample();
        PageInfo<ArticleInfoDO> pageInfo = PageHelper.startPage(pageNo,pageSize).doSelectPageInfo(() -> {
            articleInfoMapper.selectByExampleWithBLOBs(example);
        });
        PageInfo<ArticleInfoDTO> pageInfoDto = new PageInfo<>();
        pageInfoDto.setTotal(pageInfo.getTotal());
        pageInfoDto.setPageNum(pageNo);
        pageInfoDto.setPageSize(pageSize);
        List<ArticleInfoDO> articleInfoDOList = pageInfo.getList();
        pageInfoDto.setList(doListToDtoList(articleInfoDOList));
        return pageInfoDto;
    }

    @Override
    public PageInfo<ArticleInfoDTO> query(String shopeeId, Integer pageNo, Integer pageSize) {
        ArticleInfoDOExample example = new ArticleInfoDOExample();
        ArticleInfoDOExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(shopeeId)) {
            criteria.andShopeeIdEqualTo(shopeeId);
        }
        PageInfo<ArticleInfoDO> pageInfo = PageHelper.startPage(pageNo,pageSize).doSelectPageInfo(() -> {
            articleInfoMapper.selectByExampleWithBLOBs(example);
        });
        PageInfo<ArticleInfoDTO> pageInfoDto = new PageInfo<>();
        pageInfoDto.setTotal(pageInfo.getTotal());
        pageInfoDto.setPageNum(pageNo);
        pageInfoDto.setPageSize(pageSize);
        List<ArticleInfoDO> articleInfoDOList = pageInfo.getList();
        pageInfoDto.setList(doListToDtoList(articleInfoDOList));
        return pageInfoDto;
    }

    @Override
    public ArticleInfoDTO queryById(Long id) {
        ArticleInfoDO articleInfoDO = articleInfoMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public List<ArticleInfoDTO> getArticleByIdList(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Lists.newArrayList();
        }
        ArticleInfoDOExample example = new ArticleInfoDOExample();
        ArticleInfoDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        List<ArticleInfoDO> articleInfoDOList = articleInfoMapper.selectByExampleWithBLOBs(example);
        return doListToDtoList(articleInfoDOList);
    }

    private List<ArticleInfoDTO> doListToDtoList(List<ArticleInfoDO> articleInfoDOList) {
        if (CollectionUtils.isEmpty(articleInfoDOList)) {
            return Lists.newArrayList();
        }
        List<ArticleInfoDTO> articleInfoDTOList = Lists.newArrayList();
        for (ArticleInfoDO articleInfoDO : articleInfoDOList) {
            articleInfoDTOList.add(doToDto(articleInfoDO));
        }
        return articleInfoDTOList;
    }

    private ArticleInfoDTO doToDto(ArticleInfoDO articleInfoDO) {
        ArticleInfoDTO articleInfoDTO = new ArticleInfoDTO();
        BeanUtils.copyProperties(articleInfoDO,articleInfoDTO);
        articleInfoDTO.setArticlePhoto(JSON.parseArray(articleInfoDO.getArticlePhoto(),String.class));
        articleInfoDTO.setCoverPhoto(CollectionUtils.isEmpty(articleInfoDTO.getArticlePhoto()) ? null : articleInfoDTO.getArticlePhoto().get(0));
        return articleInfoDTO;
    }
}
