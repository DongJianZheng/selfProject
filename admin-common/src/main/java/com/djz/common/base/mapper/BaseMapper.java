package com.djz.common.base.mapper;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 * @author: djz
 * @date:  2020-04-03 17:14
 */
public interface BaseMapper<T> extends Mapper<T> {

    public List<T> insertBatchSelective(List<T> t);

    public Integer updateBatchByPrimaryKeySelective(List<T> t);

    public Integer deleteBatchByKeys(List<T> t);

    public List<T> selectList(T t);

}
