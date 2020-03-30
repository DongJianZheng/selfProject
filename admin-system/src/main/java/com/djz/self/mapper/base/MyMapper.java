package com.djz.self.mapper.base;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MyMapper<T> extends Mapper<T> {

    public List<T> find(T t);

    public List<T> list(T t);

    public List<T> pageList(T t);
}
