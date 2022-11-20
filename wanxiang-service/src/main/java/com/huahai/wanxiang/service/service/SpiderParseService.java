package com.huahai.wanxiang.service.service;

public interface SpiderParseService {

    void parse(String html,String url,Long tenantId);

    String getSecene();
}
