package com.huahai.wanxiang.service.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UrlUtil {

    private static final Logger logger = LoggerFactory.getLogger(UrlUtil.class);


    private static final String URL_PATTERN_RULE = "[^\\.]+(\\.shop)";

    private static Pattern URL_PATTERN = Pattern.compile(URL_PATTERN_RULE);

    public static String fillHttpHeader(String url) {
        if (StringUtils.isNotBlank(url) && url.toLowerCase().startsWith("http://") && url.toLowerCase().startsWith("https://")) {
            return "http://" + url;
        }
        return url;
    }

    public static String getTopDomain(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        try {
            String host = new URL(url).getHost().toLowerCase();
            Matcher matcher = URL_PATTERN.matcher(host);
            while (matcher.find()) {
                return matcher.group();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
