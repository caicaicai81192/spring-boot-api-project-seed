package com.company.project.core;


import com.ipampas.framework.mybatis.builder.OrderBy;
import com.ipampas.framework.mybatis.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author caizj
 * @description: 基于通用MyBatis Mapper插件的Service接口的实现
 * @date 2019/6/29 8:43 PM
 * @since 1.0.0
 */
public abstract class AbstractIpampasService<T> implements IpampasService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    @Override
    public int save(T model) {
        //
        return mapper.insertSelective(model);
    }

    @Override
    public int deleteById(Long id) {
        //
        return mapper.delete(id);
    }

    @Override
    public int deleteLogicalById(Long id) {
        //
        return mapper.deleteLogical(id);
    }

    @Override
    public int update(T model) {
        //
        return mapper.updateSelective(model);
    }

    @Override
    public T findById(Long id) {
        //
        return mapper.selectById(id);
    }

    @Override
    public <Condition> List<T> findByCondition(Condition condition) {
        //
        return mapper.selectListWithOrderWithoutTenant(condition, OrderBy.builder().desc("id"));
    }


}
