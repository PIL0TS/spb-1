package com.tream.controller;

import com.tream.entity.Test;
import com.tream.property.TestProperty;
import com.tream.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class TestController {


    @Value("${test.age}")
    private Integer age;

    @Autowired
    private TestProperty tt;

    @Autowired
    private TestProperty test2;

    @Autowired
    private ITestService testService;

    @RequestMapping(value = "hello" , method = RequestMethod.GET)
    public String testController(){

        String testStr = tt.toString() + test2.toString();

        return testStr;

    }

    @RequestMapping(value = "say/hi/{name}" , method = {RequestMethod.GET,RequestMethod.POST})
    public String hiController(@PathVariable("name") String name){
        Test test = testService.findByName(name);
        return test.toString();
    }

    @RequestMapping( value = "insert")
    public Test addTest(@RequestParam(value = "name" ,required = true) String name){
        Test test = new Test();
        test.setName(name);
        return testService.insert(test);
    }


    @RequestMapping(value = "tests")
    public List findAll(Model model){
        List<Test> list = testService.findAll();
        model.addAttribute("list",list);

        return list;
    }

    @RequestMapping( value ="test/{id}", method = RequestMethod.DELETE)
    public String deleteByids(@PathVariable("id") Integer id){
        boolean tof = testService.deleteById(new int[]{id});

        return tof + "";
    }

    @RequestMapping(value = "all" )
    public String findAll_freemarker(Model model){
        List<Test> testList = testService.findAll();
        model.addAttribute("testList",testList);
        return "testList";
    }

    @RequestMapping(value = "testJson",method = RequestMethod.GET)
    public String json(Model model){
        return "main";
    }
}
