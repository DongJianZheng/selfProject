package com.djz.self.mapper.basic;

import com.djz.self.entity.basic.RoleResource;
import com.github.pagehelper.Page;
import java.util.List;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource find(RoleResource record);

    List<RoleResource> list(RoleResource record);

    Page<RoleResource> pageList(RoleResource record);
}