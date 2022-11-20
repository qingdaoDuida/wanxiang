package com.huahai.wanxiang.dao.util;

public class SqlSecurityUtils {

    public static String trimSql(String slice) {
        if (slice == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : slice.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '_' || c == '-' || c == '.' || c == ' ' || c == ',') {
                sb.append(c);
            } else if (c == '>' || c == '<' || c == '=' || c == '\"' || c == '\'') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
