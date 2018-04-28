package com.tream.coach.user.dao;


import com.tream.coach.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDaot {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByParam(User user);

    List<User> pageQueryUser(User user, Integer m, Integer n);

    List<User> selectListByLoginId(String LoginId);

    int sumLoginId (String loginId);

    void delByIds (@Param(value="ids")int[] ids) ;
    int count(User user);

}