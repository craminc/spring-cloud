package com.cramin.springcloud.consumer.controller;

import com.cramin.springcloud.api.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ChengRuimin
 * @date: 2019/10/28 09:30
 * @description:
 */
@RestController
@RequestMapping("consumer/dept")
public class DeptController {

    private static final String REST_URL_PREFIX = "http://springcloud-dept";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/discovery", Object.class);
    }
}
