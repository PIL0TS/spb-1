package com.tream.coach.user.controller;

import com.tream.coach.user.entity.User;
import com.tream.coach.user.service.IUserService;
import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.result.ResultBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping(value = "/")
public class UserController {


    @Resource
    IUserService userService;

    @RequestMapping(value = "/info")
    public User userListTest() throws Exception {
        return userService.findById(1);
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Map pageListGet() throws Exception{
        List<User> userList = userService.pageQueryByParam(new User(), 1, 10);
        int maxRow =  userService.maxRow(new User());
        System.out.println("maxRow -- " + maxRow);
        return new HashMap(){
            {
                put("arr", userList);
                put("count", maxRow);
            }
        };
    }

    @RequestMapping(value = "/users/count",method = RequestMethod.GET)
    public int allCount() throws Exception{
        return userService.maxRow(new User());
    }

    @RequestMapping(value = "/users/{pageNum}",method = RequestMethod.POST)
    public Map pageListPost(@PathVariable(value = "pageNum") int pageNum, @RequestBody User user) throws Exception{
        System.out.println(user);
        System.out.println(pageNum);

        List<User> userList = userService.pageQueryByParam(user, pageNum < 1 ? 1 : pageNum, 10);
        int maxRow = userService.maxRow(user);
        System.out.println("maxRow" + maxRow);
        return new HashMap(){
            {
                put("arr", userList);
                put("maxRow", maxRow);
            }
        };
    }

    /**
     * 保存
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/users/add")
    public ResultBody addUser (HttpServletRequest request, @RequestBody User user) {
        try {
            System.out.println(user);
            user.setDelFlag("0");
            boolean flag = userService.insert(user);
            return new ResultBody("保存成功！","success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }

    }

    /**
     * 修改
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/users/update")
    public ResultBody updateUser (HttpServletRequest request, @RequestBody User user) {
        try {
            User newUser = userService.findById(user.getId());
            newUser.setLoginId(user.getLoginId());
            newUser.setName(user.getName());
            newUser.setRole(user.getRole());
            newUser.setSex(user.getSex());
            newUser.setTel(user.getTel());
            newUser.setAddress(user.getAddress());
            newUser.setMail(user.getMail());
            boolean flag = userService.update(newUser);
            return new ResultBody("保存成功！","success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }

    }

    /**
     * 验证 login
     * @param request
     * @param
     * @return
     */
    @RequestMapping(value = "/users/check/{loginId}")
    public ResultBody check (HttpServletRequest request, @PathVariable(value = "loginId") String loginId) {
        System.out.println(loginId);
        try {
            int sum = userService.allLoginId(loginId);
            System.out.println(sum);
            return sum > 0 ? new ResultBody("登录名已存在！", "n") : new ResultBody("登录名可用", "y");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }
    }
    /**
     * 验证 login
     * @param request
     * @param
     * @return
     */
    @PostMapping("/users/delIds")
    public ResultBody delIds (HttpServletRequest request, @RequestBody int[] ids) {
        try {
            System.out.println(Arrays.toString(ids));
            if (ids != null && ids.length > 0) {
                userService.delByIds(ids);
                return new ResultBody("删除成功");
            } else {
                return new ResultBody(GlobalErrorInfoEnum.PARAM_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.PARAM_ERROR);
        }

    }

    /**
     * ------
     * @param req
     * @param user
     * @return
     */
    @RequestMapping(value = "/getOneUser")
    public ResultBody getOne (HttpServletRequest req, @RequestBody User user) {

        System.out.println(user);
        User result = null;
        try {
            result = userService.findById(1);
        } catch (Exception e) {
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }
        return result != null ? new ResultBody(result) : new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
    }























}
