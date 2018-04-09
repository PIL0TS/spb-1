package com.tream.coach.line.service.impl;

import com.tream.coach.line.dao.IRodeLineDao;
import com.tream.coach.line.entity.RodeLine;
import com.tream.coach.line.service.IRodeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RodeLineServiceImpl implements IRodeLineService {

    @Autowired
    IRodeLineDao lineDao;

    @Override
    public boolean insertTest(Integer num) throws Exception {

        try{
            for(int i = 0; i < 1; i++){
                RodeLine rodeLine = new RodeLine();
                rodeLine.setId(3200 + i);
                rodeLine.setDelFlag("0");
                int flag = lineDao.insertSelective(rodeLine);
                System.out.println(i);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<RodeLine> pageQueryByPrama() throws Exception {

        RodeLine rl = new RodeLine();

        List<RodeLine> list = lineDao.pageQueryLine(rl, 3, 3);



        return list;
    }
}
