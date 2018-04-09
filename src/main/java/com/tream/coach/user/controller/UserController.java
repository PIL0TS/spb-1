package com.tream.coach.user.controller;

import com.tream.coach.user.entity.User;
import com.tream.coach.user.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@RequestMapping(value = "/")
public class UserController {


    @Resource
    IUserService userService;

    @RequestMapping(value = "/info")
    public User userListTest() {
        return userService.findById(1);
    }

    @RequestMapping(value = "/users")
    public List<User> pageList() {
        List<User> userList = userService.pageQueryByParam(new User(), 0, 10);
        userList.forEach(
          item -> {
              System.out.println(item.toString());
          }
        );
        return userList;
    }
}
