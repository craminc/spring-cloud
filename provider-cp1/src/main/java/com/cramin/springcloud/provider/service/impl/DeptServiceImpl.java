package com.cramin.springcloud.provider.service.impl;

import com.cramin.springcloud.api.entities.Dept;
import com.cramin.springcloud.provider.dao.DeptDao;
import com.cramin.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 14:55
 * @description:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        if (deptDao.insert(dept) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Dept get(Long id) {
        return deptDao.selectByPrimaryKey(Dept.builder().deptno(id).build());
    }

    @Override
    public List<Dept> list() {
        return deptDao.selectAll();
    }
}
