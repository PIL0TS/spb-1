package com.tream.coach.line.dao;


import com.tream.coach.line.entity.RodeLine;

import java.util.List;

public interface IRodeLineDao {
    int deleteByPrimaryKey(Integer id);

    int insert(com.tream.coach.line.entity.RodeLine record);

    int insertSelective(com.tream.coach.line.entity.RodeLine record);

    com.tream.coach.line.entity.RodeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(com.tream.coach.line.entity.RodeLine record);

    int updateByPrimaryKey(com.tream.coach.line.entity.RodeLine record);




    List<RodeLine> pageQuery(RodeLine rodeLine, int m, int n);

    int count(RodeLine rodeLine);
}