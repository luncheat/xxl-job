package com.xxl.job.admin.sm4;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sm4Test {
    @Resource
    StringEncryptor stringEncryptor;

    @Test
    public void sm4Test() {
        String username = stringEncryptor.encrypt("root");
        String password = stringEncryptor.encrypt("123456");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

}
