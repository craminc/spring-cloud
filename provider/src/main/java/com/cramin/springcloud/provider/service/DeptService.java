package com.cramin.springcloud.provider.service;

import com.cramin.springcloud.api.entities.Dept;

import java.util.List;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 14:54
 * @description:
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
