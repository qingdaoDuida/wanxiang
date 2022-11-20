package com.huahai.wanxiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WanxiangApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanxiangApplication.class);
    }
}
