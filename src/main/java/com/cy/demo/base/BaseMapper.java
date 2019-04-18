package com.cy.demo.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper接口,该接口在不能被包扫描时扫到否则会报错
 */

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
