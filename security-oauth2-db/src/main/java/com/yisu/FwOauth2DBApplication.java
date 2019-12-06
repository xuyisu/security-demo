package com.yisu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xuyisu
 * @date 2019/9/29
 */
@SpringBootApplication
@EnableCaching
@MapperScan(value = "com.yisu.oauth2.db.mapper")
public class FwOauth2DBApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwOauth2DBApplication.class);
    }



}
