package com.djz.self.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.djz.self.domain.basic.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}