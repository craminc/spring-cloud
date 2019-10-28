package com.cramin.springcloud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ChengRuimin
 * @date: 2019/10/25 11:07
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;
}
