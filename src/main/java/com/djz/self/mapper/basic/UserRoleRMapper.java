package com.djz.self.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.djz.self.domain.basic.UserRoleR;
@Mapper
public interface UserRoleRMapper {
    int insert(UserRoleR record);

    List<UserRoleR> selectAll();
}