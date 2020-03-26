package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Double id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Double id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}