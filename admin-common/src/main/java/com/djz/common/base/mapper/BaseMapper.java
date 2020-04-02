package com.djz.common.base.mapper;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface BaseMapper<T> extends Mapper<T> {

    public List<T> find(T t);

    public List<T> list(T t);

    public List<T> pageList(T t);
}
