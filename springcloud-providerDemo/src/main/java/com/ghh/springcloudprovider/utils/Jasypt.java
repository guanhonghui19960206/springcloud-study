package com.ghh.springcloudprovider.utils;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @className: Jasypt
 * @description: 加密类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-06 17:50
 **/
public class Jasypt {

    private static final String PRI="ENC(";
    private static final String SUF=")";
    private static final String FORMAT="ENC(%s)";

    private static final String PASSWORD="vjbvfhvbvhjbvhjdbbvfhvb";

    public static void main(String[] args){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(PASSWORD);

        /*代加密字段*/
        String str="ewee";
        /*加密*/
        String enStr=String.format(FORMAT,encryptor.encrypt(str));
        System.out.println("加密后的秘闻："+enStr);

        /*解密*/
        String decStr = encryptor.decrypt(getIntr(enStr));
        System.out.println("解密后原文："+decStr);

    }

    private static String getIntr(final String value){

        return value.substring(PRI.length(),(value.length() - SUF.length()));
    }

}
