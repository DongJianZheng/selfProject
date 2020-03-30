package com.djz.self.mapper.basic;

import com.djz.self.entity.basic.User;
import com.github.pagehelper.Page;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User find(User record);

    List<User> list(User record);

    Page<User> pageList(User record);
}