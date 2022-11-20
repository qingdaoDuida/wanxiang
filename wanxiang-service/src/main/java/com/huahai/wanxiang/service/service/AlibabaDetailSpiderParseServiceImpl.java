package com.huahai.wanxiang.service.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huahai.wanxiang.dao.domain.ArticleInfoDO;
import com.huahai.wanxiang.dao.mapper.ArticleInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Objects;


@Service
public class AlibabaDetailSpiderParseServiceImpl implements SpiderParseService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Override
    public void parse(String html, String url, Long tenantId) {
        if (StringUtils.isBlank(html)) {
            return;
        }
        Document document = Jsoup.parse(html);
        Element body = document.body();
        /**
         * 商品名称
         */
        Elements titleElements = body.getElementsByClass("title-text");
        String articleName = titleElements.get(0).text();
        /**
         * 商品描述
         */
        /**
         * 全球商品价格
         */
        Elements priceElements = body.getElementsByClass("price-column");
        if (CollectionUtils.isEmpty(priceElements)) {
            priceElements = body.getElementsByClass("step-price-wrapper");
        }
        Elements priceText = priceElements.get(0).getElementsByClass("price-text");
        String price = priceText.get(0).text();
        // 库存

        // 封面图
        Elements imgElements = body.getElementsByClass("img-list-wrapper");
        String img = imgElements.get(0).getElementsByClass("detail-gallery-img").get(0).attr("src");
        // 重量
        String weightStr = body.getElementsByClass("od-pc-offer-cross").get(0).getElementsByClass("offer-attr").
                get(0).getElementsByClass("offer-attr-item").
                get(0).getElementsByClass("offer-attr-item-value").
                get(0).text();
        String weight = weightStr.substring(0,weightStr.indexOf("kg"));
        // 出货天数

        // 品牌

        ArticleInfoDO articleInfoDO = new ArticleInfoDO();
        articleInfoDO.setArticleName(articleName);
        articleInfoDO.setOriginalPrice(new BigDecimal(price));
        articleInfoDO.setArticlePhoto(JSON.toJSONString(Lists.newArrayList(img)));
        articleInfoDO.setWeight(new BigDecimal(weight));
        articleInfoDO.setTenantId(tenantId);
        articleInfoDO.setArticleSourceUrl(url);
        articleInfoMapper.insertSelective(articleInfoDO);
    }

    @Override
    public String getSecene() {
        return null;
    }
}
