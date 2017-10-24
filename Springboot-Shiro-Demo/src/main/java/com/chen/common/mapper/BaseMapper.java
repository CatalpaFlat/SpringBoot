package com.chen.common.mapper;

import com.chen.common.entity.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈梓平 on 2017/9/18.
 */
public interface BaseMapper <T,PK extends Serializable> {

    /**
     * 增加对象
     * @param obj
     */
    public void add(T obj);

    /**
     * 修改对象
     * @param obj
     */
    public int update(T obj);

    /**
     * 根据主键删除对象
     * @param pk
     */
    public int delete(PK pk);

    /**
     * 根据主键得到某个对象
     * @param pk
     */
    public T get(PK pk);

    /**
     * 根据条件查询数据
     * @param q
     * @return
     */
    public List<T> queryAll(Query q);

    /**
     * 只查询需要的列名的list
     * @param q
     * @return list key为数据库中带有下划线的key,需要转驼峰结构
     */
    public   List<Map<String, Object>> queryColumnList(Query q);
}
