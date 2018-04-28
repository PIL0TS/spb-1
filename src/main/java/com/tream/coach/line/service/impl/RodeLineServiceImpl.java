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


    /**
     * ----测试数据
     * @param num
     * @return
     * @throws Exception
     */
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
    public List<RodeLine> pageQueryByParam(RodeLine rodeLine, int pageNum, int numPerPage) {
        int m = (pageNum - 1) * numPerPage;

        return lineDao.pageQuery(rodeLine, m, 10);
    }

    @Override
    public int maxRow(RodeLine rodeLine) {
        return lineDao.count(rodeLine);
    }

    @Override
    public boolean insert(RodeLine rodeLine){
        try {
            lineDao.insert(rodeLine);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(RodeLine rodeLine) {
        if(lineDao.updateByPrimaryKey(rodeLine) < 0) {
            return false;
        } else {
            return true;
        }
    }


}
