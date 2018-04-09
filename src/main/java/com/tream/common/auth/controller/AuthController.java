package com.tream.common.auth.controller;

import com.tream.coach.user.entity.User;
import com.tream.common.auth.controller.dto.AuthRequest;
import com.tream.common.auth.controller.dto.AuthResponse;
import com.tream.common.auth.util.JwtTokenUtil;
import com.tream.common.auth.validator.IReqValidator;
import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.result.GlobalErrorInfoException;
import com.tream.common.result.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class AuthController {
    Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "dbValidator")
    private IReqValidator reqValidator;


    @RequestMapping(value = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getCredenceName(), randomKey);
            log.info("登录成功 [ liginId = '" + authRequest.getLoginId() + "', psw = '" + authRequest.getPassWord() + "']");
            return ResponseEntity.ok(new AuthResponse(token, randomKey));

        } else {
            System.out.println("登录未成功 [ liginId = '" + authRequest.getLoginId() + "', psw = '" + authRequest.getPassWord() + "']");
            ResultBody result = new ResultBody(GlobalErrorInfoEnum.LOGIN_ERROR);

            return ResponseEntity.ok(result);
        }

    }

}
