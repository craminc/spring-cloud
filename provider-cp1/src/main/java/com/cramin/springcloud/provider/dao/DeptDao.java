package com.cramin.springcloud.provider.dao;

import com.cramin.springcloud.api.entities.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 14:45
 * @description:
 */
@Repository
public interface DeptDao extends Mapper<Dept>, MySqlMapper<Dept> {
}
