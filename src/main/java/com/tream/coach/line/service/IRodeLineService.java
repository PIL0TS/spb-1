package com.tream.coach.line.service;

import com.tream.coach.line.entity.RodeLine;

import java.util.List;

public interface IRodeLineService {

    boolean insertTest(Integer num) throws Exception;

    List<RodeLine> pageQueryByParam(RodeLine rodeLine, int i, int i1);

    int maxRow(RodeLine rodeLine);

    boolean insert(RodeLine line);

    boolean update(RodeLine newLine);
}
