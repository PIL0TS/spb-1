package com.tream.coach.line.controller;

import com.tream.coach.line.entity.RodeLine;
import com.tream.coach.line.service.IRodeLineService;
import com.tream.common.result.ResultBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/line")
public class LineController {

    @Resource
    IRodeLineService rodeLineService;

    @RequestMapping(value = "/insertLines")
    public boolean insertTest() throws Exception {

        boolean flag = rodeLineService.insertTest(0);

        return flag;

    }

    @RequestMapping(value = "/pageLine")
    public ResultBody pageInit() throws Exception{
        System.out.println("ppppp");
        List<RodeLine> list = rodeLineService.pageQueryByPrama();
        System.out.println(list);
        return new ResultBody(list);
    }


}
