package com.cramin.springcloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ChengRuimin
 * @date: 2019/10/28 09:26
 * @description:
 */
@Configuration
public class ConfigBean {

    /**
     * 实现负载均衡（默认轮询算法）
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
