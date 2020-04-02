package com.djz.self.base.service.impl;
import com.djz.common.base.mapper.BaseMapper;
import com.djz.self.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class BaseServiceImpl<M extends BaseMapper<T>, T>  implements BaseService<M, T> {

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity){
       return mapper.selectOne(entity);
    }


}
