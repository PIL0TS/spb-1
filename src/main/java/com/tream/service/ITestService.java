package com.tream.service;

import com.tream.dao.ITestDao;
import com.tream.entity.Test;

import java.util.List;

public interface ITestService {
    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    Test findByName(String name);

    /**
     * 新增
     * @param test
     * @return
     */
    Test insert(Test test);


    /**
     * 更新
     * @param test
     * @return
     */
    Boolean update(Test test);

    /**
     * 根据主键删除
     * @param ids
     * @return
     */
    Boolean deleteById(int[] ids);

    /**
     * 查询所有
     * @return
     */
    List<Test> findAll();
}
