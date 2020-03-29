package com.djz.self.entity.basic.mapper;

import com.djz.self.entity.basic.Resource;
import com.github.pagehelper.Page;
import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    Resource find(Resource record);

    List<Resource> list(Resource record);

    Page<Resource> pageList(Resource record);
}