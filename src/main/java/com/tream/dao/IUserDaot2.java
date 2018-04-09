package com.tream.dao;

import com.tream.entity.User;

import java.util.List;

public interface IUserDaot2 {



    List<User> selectListByUserName(String userName);

}
