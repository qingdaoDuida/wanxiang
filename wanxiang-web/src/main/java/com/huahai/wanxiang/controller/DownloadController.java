package com.huahai.wanxiang.controller;

import com.huahai.wanxiang.service.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/download/")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @GetMapping("article")
    public void downArticle(String ids) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition","attachment;filename" + "虾皮商品批量上传文件.xlsx");
        downloadService.downloadArticle(ids,response);
    }
}
