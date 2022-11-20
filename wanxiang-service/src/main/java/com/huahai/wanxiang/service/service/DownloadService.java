package com.huahai.wanxiang.service.service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public interface DownloadService {

    void downloadArticle(String ids, HttpServletResponse response);
}
