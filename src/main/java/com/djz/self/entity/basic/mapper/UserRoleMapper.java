package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}