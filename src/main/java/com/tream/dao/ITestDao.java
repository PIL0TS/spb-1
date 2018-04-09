package com.tream.dao;

import com.tream.entity.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITestDao {

    /**
     * 根据name字段查询
     * @param name
     * @return
     */
    Test findByName( @Param("name") String name);

    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Test entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(  Test entity);

    /**
     * 根据主键删除
     * @param ids
     * @return
     */
    int deleteById(int[] ids);

    /**
     * 查询所有
     * @return
     */
    List findAll();




}
