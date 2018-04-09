package com.tream.coach.line.service;

import com.tream.coach.line.entity.RodeLine;

import java.util.List;

public interface IRodeLineService {

    boolean insertTest(Integer num) throws Exception;

    List<RodeLine> pageQueryByPrama() throws Exception;



}
