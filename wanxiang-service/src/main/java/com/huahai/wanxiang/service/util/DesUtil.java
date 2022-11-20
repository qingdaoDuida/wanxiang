package com.huahai.wanxiang.service.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {

    public static final String SECRET = "huahaiwx";

    private static byte[] hexStringToBytes(String hexString) {
        if (hexString.length() % 2 != 0) {
            throw new IllegalArgumentException("hexString length not valid");
        }
        int length = hexString.length() / 2;
        byte[] resultBytes = new byte[length];
        for (int index = 0; index < length; index++) {
            String result = hexString.substring(index * 2,index * 2 + 2);
            resultBytes[index] = Integer.valueOf(Integer.parseInt(result,16)).byteValue();
        }
        return resultBytes;
    }

    private static String bytesToHexString(byte[] source) {
        if (source == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (byte souce : source) {
            String result = Integer.toHexString(souce& 0xff);
            if (result.length() < 2) {
                result = "0" + result;
            }
            builder.append(result);
        }
        return builder.toString();
    }

    public static String encryptByDES(String input,String key) throws Exception {
        String algorithm = "DES";
        String transformation = "DES";
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(),algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,sks);
        byte[] bytes = cipher.doFinal(input.getBytes());
        return bytesToHexString(bytes);
    }

    public static String decryptByDES(String input,String key) throws Exception {
        String algorithm = "DES";
        String transformation = "DES";
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(),algorithm);
        cipher.init(Cipher.DECRYPT_MODE,sks);
        byte[] inputBytes = hexStringToBytes(input);
        byte[] bytes = cipher.doFinal(inputBytes);
        return new String(bytes);
    }
}
