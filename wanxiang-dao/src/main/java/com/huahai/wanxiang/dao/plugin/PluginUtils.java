package com.huahai.wanxiang.dao.plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class PluginUtils {

    public static String getJavaDocLine(String className) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("/**").append("\n");
        builder.append("/* "+ className).append("\n");
        builder.append(" *").append("\n");
        builder.append(" * @author " + "haofuwei").append("\n");
        builder.append(" * @version " + simpleDateFormat.format(new Date())).append("\n");
        builder.append(" */");
        return builder.toString();
    }
}
