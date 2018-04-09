package com.tream.common.auth.validator.impl;

import com.tream.coach.user.dao.IUserDaot;
import com.tream.coach.user.entity.User;
import com.tream.common.auth.validator.IReqValidator;
import com.tream.common.auth.validator.dto.Credence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 */
@Service
public class DbValidator implements IReqValidator {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IUserDaot userDao;


    @Override
    public boolean validate(Credence credence) {

        List<User> userList = userDao.selectListByLoginId(credence.getCredenceName());

        if (userList != null && userList.size() > 0) {
            log.info(credence.getCredenceName() + ": 登录成功。" );
            return true;
        } else {
            log.info(credence.getCredenceName() + ": 登录失败。" );
            return false;
        }

    }
}
