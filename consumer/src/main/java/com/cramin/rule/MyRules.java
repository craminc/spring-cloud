package com.cramin.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChengRuimin
 * @date: 2019/10/29 16:42
 * @description:
 */
@Configuration
public class MyRules {

    @Bean
    public IRule myRule() {
        return new CustomRule();
    }
}
