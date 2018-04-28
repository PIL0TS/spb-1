package com.tream.coach.user.service.impl;

import com.tream.coach.user.dao.IUserDaot;
import com.tream.coach.user.entity.User;
import com.tream.coach.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDaot userDao;


    @Override
    public boolean insert(User entity) throws Exception {

        try {
            userDao.insert(entity);
            return true;
        } catch (Exception e) {
            throw new Exception("添加用户错误");
        }

    }

    @Override
    public boolean update(User entity) {
        if(userDao.updateByPrimaryKey(entity) < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(int id) {

        if (userDao.deleteByPrimaryKey(id) < 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List<User> findAllByParam(User entity) {
        return userDao.findByParam(entity);
    }

    @Override
    public List<User> pageQueryByParam(User entity, Integer pageNum, Integer numPerPage) {

        int m = (pageNum - 1) * numPerPage;

        return userDao.pageQueryUser(entity, m, 10);



    }

    @Override
    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
    @Override
    public int allLoginId(String loginId) throws Exception {
       try{
           return userDao.sumLoginId(loginId);
       } catch (Exception e) {
           e.printStackTrace();
           return  -1;
       }

    }

    @Override
    public int delByIds(int[] ids) throws Exception {
        try {
            userDao.delByIds(ids);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
    }

    @Override
    public int maxRow(User user) throws Exception {

        int i = userDao.count(user);

        return i;
    }
}
