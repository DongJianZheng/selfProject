package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.Role;
import com.github.pagehelper.Page;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);

    Role find(Role record);

    List<Role> list(Role record);

    Page<Role> pageList(Role record);
}