package com.djz.self.mapper.basic;

import com.djz.self.domain.basic.RoleResourcer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RoleResourcerMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResourcer record);

    RoleResourcer selectByPrimaryKey(String id);

    List<RoleResourcer> selectAll();

    int updateByPrimaryKey(RoleResourcer record);
}