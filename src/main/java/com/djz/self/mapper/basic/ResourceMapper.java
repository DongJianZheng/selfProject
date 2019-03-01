package com.djz.self.mapper.basic;

import com.djz.self.domain.basic.Resource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    Resource selectByPrimaryKey(String id);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}