package com.djz.self.mapper.basic;

import com.djz.self.domain.basic.RoleBusiness;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RoleBusinessMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleBusiness record);

    RoleBusiness selectByPrimaryKey(String id);

    List<RoleBusiness> selectAll();

    int updateByPrimaryKey(RoleBusiness record);
}