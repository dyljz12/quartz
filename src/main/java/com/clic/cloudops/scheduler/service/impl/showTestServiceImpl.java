package com.clic.cloudops.scheduler.service.impl;

import com.clic.cloudops.scheduler.dao.AreaDao;
import com.clic.cloudops.scheduler.model.Area;
import com.clic.cloudops.scheduler.service.showTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class showTestServiceImpl implements showTestService {
    @Autowired
    AreaDao areaDao;
    @Override
    public List<Area> showAll(){
        return areaDao.all();
    }
}
