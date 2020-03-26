package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}