package com.djz.self.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.djz.self.domain.basic.Role;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}