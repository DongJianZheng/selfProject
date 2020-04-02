package com.djz.self.base.service;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
public interface BaseService<M extends BaseMapper<T>, T> {



    /**
     * 返回单个对象
     * @param entity
     * @return
     */
    public T selectOne(T entity);




}   
