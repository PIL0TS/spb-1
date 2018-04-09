package com.tream.service.impl;

import com.tream.dao.ITestDao;
import com.tream.entity.Test;
import com.tream.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    private ITestDao testDao;

    /**
     * 根据name查询
     * @param name
     * @return
     */
    @Override
    public Test findByName(String name) {
        Test test = testDao.findByName(name);
        return test;

    }

    /**
     * 新增
     * @param test
     * @return
     */
    @Override
    public Test insert(Test test) {
        test.setAge(testDao.insert(test));
        return test ;
    }

    /**
     * 根据主键删除
     * @param test
     * @return
     */
    @Override
    public Boolean update(Test test) {
        return null;
    }


    /**
     * 根据主键删除
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteById(int[] ids) {

        int tof = testDao.deleteById(ids);

        return tof>0?true:false;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Test> findAll() {
        return (List<Test>)testDao.findAll();
    }
}
