package com.tream.controller;

import com.tream.entity.Test;
import com.tream.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HTMLController {

    @Autowired
    ITestService testService;

    @RequestMapping(value = "testHtml" , method = RequestMethod.GET)
    public String testhtml(Model model){

        List<Test> testList = testService.findAll();
        model.addAttribute(testList);

        return "main";
    }
}
