package com.tream.coach.line.controller;

import com.tream.coach.line.entity.RodeLine;
import com.tream.coach.line.service.IRodeLineService;
import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.result.ResultBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping(value = "/line")
public class LineController {

    @Resource
    IRodeLineService rodeLineService;

    
    @RequestMapping(value = "/line",method = RequestMethod.GET)
    public Map pageListGet() throws Exception{
        List<RodeLine> lineList = rodeLineService.pageQueryByParam(new RodeLine(), 1, 10);
        int maxRow =  rodeLineService.maxRow(new RodeLine());
        System.out.println("maxRow -- " + maxRow);
        return new HashMap(){
            {
                put("arr", lineList);
                put("count", maxRow);
            }
        };
    }

    @RequestMapping(value = "/line/count",method = RequestMethod.GET)
    public int allCount() throws Exception{
        return rodeLineService.maxRow(new RodeLine());
    }

    @RequestMapping(value = "/line/{pageNum}",method = RequestMethod.POST)
    public Map pageListPost(@PathVariable(value = "pageNum") int pageNum, @RequestBody RodeLine line) throws Exception{

        List<RodeLine> RodeLineList = rodeLineService.pageQueryByParam(line, pageNum < 1 ? 1 : pageNum, 10);
        int maxRow = rodeLineService.maxRow(line);
        System.out.println("maxRow" + maxRow);
        return new HashMap(){
            {
                put("arr", RodeLineList);
                put("maxRow", maxRow);
            }
        };
    }

    /**
     * 保存
     * @param request
     * @param line
     * @return
     */
    @RequestMapping(value = "/RodeLines/add")
    public ResultBody addRodeLine (HttpServletRequest request, @RequestBody RodeLine line) {
        try {
            line.setDelFlag("0");
            boolean flag = rodeLineService.insert(line);
            return new ResultBody("保存成功！","success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }

    }

    /**
     * 修改
     * @param request
     * @param line
     * @return
     */
    @RequestMapping(value = "/line/update")
    public ResultBody updateRodeLine (HttpServletRequest request, @RequestBody RodeLine line) {
        try {
//            RodeLine newLine = rodeLineService.findById(line.getId());
//            newLine.setLoginId(line.getLoginId());
//            newLine.setName(line.getName());
//            newLine.setRole(line.getRole());
//            newLine.setSex(line.getSex());
//            newLine.setTel(line.getTel());
//            newLine.setAddress(line.getAddress());
//            newLine.setMail(line.getMail());
//            boolean flag = rodeLineService.update(newLine);
            return new ResultBody("保存成功！","success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBody(GlobalErrorInfoEnum.QUERY_ERROR);
        }

    }











}
