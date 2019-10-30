package com.cramin.springcloud.provider.controller;

import com.cramin.springcloud.api.entities.Dept;
import com.cramin.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 15:09
 * @description:
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("*****" + list + "*****");

        List<ServiceInstance> serviceList = discoveryClient.getInstances("springcloud-dept");
        for (ServiceInstance instance : serviceList) {
            System.out.println(instance.getServiceId() + "\n" + instance.getHost()
                    + "\n" + instance.getPort() + "\n" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
