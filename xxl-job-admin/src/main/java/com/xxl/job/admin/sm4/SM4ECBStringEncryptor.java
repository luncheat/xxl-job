package com.xxl.job.admin.sm4;

import cn.hutool.crypto.SmUtil;
import org.jasypt.commons.CommonUtils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component("sM4ECBStringEncryptor")
public class SM4ECBStringEncryptor implements StringEncryptor {

    @Value("${jasypt.encryptor.salt}")
    private String salt;

    @Override
    public String encrypt(String msg) {
        CommonUtils.validateNotNull(msg, "msg cannot be set null");
        msg = SmUtil.sm4(salt.getBytes()).encryptHex(msg);
        return msg;
    }

    @Override
    public String decrypt(String msg) {
        CommonUtils.validateNotNull(msg, "msg cannot be set null");
        System.out.println("解析前的字符："+msg);
        msg = SmUtil.sm4(salt.getBytes()).decryptStr(msg);
        System.out.println("解析后的字符："+msg);
        return msg;
    }



    public static void main( String[] args) {
        SM4ECBStringEncryptor sm4ECBStringEncryptor = new SM4ECBStringEncryptor();
        sm4ECBStringEncryptor.salt = "memect2023062601";
        String encrypt = sm4ECBStringEncryptor.encrypt("root");
        System.out.println(encrypt);
        encrypt = sm4ECBStringEncryptor.encrypt("123456");
        System.out.println(encrypt);
    }
}