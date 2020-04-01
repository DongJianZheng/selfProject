package com.djz.self.service.impl;
import com.djz.self.base.BaseMapper;
import com.djz.self.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    public void setBaseDao(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }
 
    public void save(T entity) {
        baseMapper.insert(entity);
    }

    public void delete(T entity) {
        baseMapper.delete(entity);
    }

   public void update(T entity) {
        baseMapper.updateByPrimaryKey(entity);
    }

    public List<T> select(T entity) {
        return baseMapper.select(entity);
    }

    public T findById(Serializable id) {
        return baseMapper.selectByPrimaryKey(id);
    }
    public List<T> getAll() {
        return baseMapper.selectAll();
    }

    public void saveSelective(T entity) {
        baseMapper.insertSelective(entity);
    }

    public void updateSelective(T entity) {
        baseMapper.updateByPrimaryKeySelective(entity);
    }


 
}
