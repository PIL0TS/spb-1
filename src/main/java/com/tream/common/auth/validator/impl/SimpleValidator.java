package com.tream.common.auth.validator.impl;

import com.tream.common.auth.validator.IReqValidator;
import com.tream.common.auth.validator.dto.Credence;
import org.springframework.stereotype.Service;

@Service
public class SimpleValidator implements IReqValidator{

    private static String USER_NAME = "sysadmin";

    private static String PASSWORD = "000000";


    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
