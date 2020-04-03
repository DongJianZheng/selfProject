package com.djz.self.base.service;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseService<M extends BaseMapper<T>, T> {



    /**
     * 返回单个对象
     * @param entity
     * @return
     */
    public T selectOne(T entity);


    /**
     * 查询数据分页
     * @author: djz
     * @param entity
     * @Return
     * @date:  2020-04-03 10:07
     */
    List<T> queryAll(T entity);

    /**
     * 根据ID查询
     * @author: djz
     * @param id
     * @Return T
     * @date:  2020-04-03 10:07
     */
    T findById(Integer id);

    /**
     * 创建
     * @author: djz
     * @param entity
     * @Return T
     * @date:  2020-04-03 10:07
     */
    Integer create(T entity);

    /**
     * 编辑
     * @param entity
     */
    void update(T entity);

    /**
     * 删除
     * @param entity
     */
    void delete(T entity);

    /**
     *分页查询
     * @author: djz
     * @param pageNum
     * @param pageSize
     * @param entity
     * @Return
     * @date:  2020-04-03 20:04
     */
    public PageInfo<T> findByPage(int pageNum, int pageSize, T entity);


}   
