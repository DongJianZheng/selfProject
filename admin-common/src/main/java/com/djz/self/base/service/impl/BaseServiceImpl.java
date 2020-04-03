package com.djz.self.base.service.impl;
import com.djz.common.base.mapper.BaseMapper;
import com.djz.self.base.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class BaseServiceImpl<M extends BaseMapper<T>, T>  implements BaseService<M, T> {

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    /**
     * 返回单个对象
     * @param entity
     * @return
     */
    public T selectOne(T entity){
        return mapper.selectOne(entity);
    }


    /**
     * 查询数据分页
     * @author: djz
     * @param entity
     * @Return
     * @date:  2020-04-03 10:07
     */
    public List<T> queryAll(T entity){
        return mapper.select(entity);
    }

    /**
     * 根据ID查询
     * @author: djz
     * @param id
     * @Return T
     * @date:  2020-04-03 10:07
     */
    public T findById(Integer id){
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 创建
     * @author: djz
     * @param entity
     * @Return T
     * @date:  2020-04-03 10:07
     */
    public Integer create(T entity){
        return mapper.insertSelective(entity);
    }

    /**
     * 编辑
     * @param entity
     */
    public void update(T entity){
        mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除
     * @param entity
     */
    public void delete(T entity){
        mapper.delete(entity);
    }


    /**
     *
     * @author: djz
     * @param pageNum
     * @param pageSize
     * @param entity
     * @Return
     * @date:  2020-04-03 20:03
     */
    public PageInfo<T> findByPage(int pageNum, int pageSize, T entity) {
        // 分页查询（紧跟在其后的第一条查询sql将会被分页）
        PageHelper.startPage(pageNum,pageSize);
        // 查询全部
        List<T> list = this.mapper.selectList(entity);
        // 返回结果
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
