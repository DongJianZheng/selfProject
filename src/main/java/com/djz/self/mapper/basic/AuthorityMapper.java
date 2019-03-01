package com.djz.self.mapper.basic;

import com.djz.self.domain.basic.Authority;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AuthorityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Authority record);

    Authority selectByPrimaryKey(String id);

    List<Authority> selectAll();

    int updateByPrimaryKey(Authority record);
}