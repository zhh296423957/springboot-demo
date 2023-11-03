package com.coocaa.telecloudmanage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.coocaa.telecloudmanage"})
@MapperScan(basePackages = "com.coocaa.telecloudmanage.mapper")
public class TeleCloudManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeleCloudManageApplication.class, args);
    }

}
