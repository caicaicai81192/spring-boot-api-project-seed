package com.company.project.core;

import java.util.List;

/**
 * @author caizj
 * @description: Service 层 基础接口，其他Service 接口 请继承该接口
 * @date 2019/6/29 8:47 PM
 * @since 1.0.0
 */
public interface IpampasService<T> {
    /**
     * 持久化
     *
     * @param model
     * @return
     */
    int save(T model);

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    int deleteLogicalById(Long id);

    /**
     * 更新
     *
     * @param model
     */
    int update(T model);

    /**
     * 通过ID查找
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 根据条件查找
     *
     * @param condition
     * @param <Condition>
     * @return
     */
    <Condition> List<T> findByCondition(Condition condition);

}
