package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.UserRole;
import com.github.pagehelper.Page;
import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole find(UserRole record);

    List<UserRole> list(UserRole record);

    Page<UserRole> pageList(UserRole record);
}