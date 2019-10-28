package com.cramin.springcloud.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Repository;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 13:48
 * @description:
 */
@SpringBootApplication
@MapperScan(value = "com.cramin.springcloud.provider.dao", annotationClass = Repository.class)
@EnableEurekaClient
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}