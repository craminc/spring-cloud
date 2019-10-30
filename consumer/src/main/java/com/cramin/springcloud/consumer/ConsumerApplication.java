package com.cramin.springcloud.consumer;

import com.cramin.rule.MyRules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author ChengRuimin
 * @date: 2019/10/28 10:17
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "springcloud-dept", configuration = MyRules.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
