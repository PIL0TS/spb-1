package com.tream.coach.user.service;

import com.tream.coach.user.entity.User;

import java.util.List;

public interface IUserService {

    boolean insert(User entity) throws Exception;

    boolean update(User entity) throws Exception;

    boolean delete(int id) throws Exception;

    List<User> findAllByParam(User entity) throws Exception;

    List<User> pageQueryByParam(User entity, Integer m, Integer n) throws Exception;

    User findById(Integer id) throws Exception;

    int allLoginId(String loginId) throws Exception;

    int delByIds (int [] ids) throws Exception;

    int maxRow (User user) throws Exception;


}
