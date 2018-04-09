package com.tream.coach.user.service;

import com.tream.coach.user.entity.User;

import java.util.List;

public interface IUserService {

    boolean insert(User entity);

    boolean update(User entity);

    boolean delete(int id);

    List<User> findAllByParam(User entity);

    List<User> pageQueryByParam(User entity, Integer m, Integer n);

    User findById(Integer id);








}
