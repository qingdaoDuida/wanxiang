package com.huahai.wanxiang.service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ArticleInfoDTO {

    private Long id;

    private String articleName;

    private String category;

    private String articleSourceUrl;

    private String sourceCompany;

    private String coverVideo;

    private String shopeeId;

    private BigDecimal weight;

    private BigDecimal originalPrice;

    private String articleStatus;

    private Integer normalStock;

    private String articleCondition;

    private Integer articleDangerous;

    private Long tenantId;

    private String articleDesc;

    private List<String> articlePhoto;

    private String coverPhoto;

    private String dimension;

    private String logisticInfo;

    private String preOrder;

    private String wholesale;

    private String taxInfo;

    private String complaintPolicy;

    private String attributeList;
}
