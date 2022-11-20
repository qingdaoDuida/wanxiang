package com.huahai.wanxiang.params;

import lombok.Data;

@Data
public class SpiderByUrlParam {

    private String html;
    private String url;
    private Long tenantId;
}
