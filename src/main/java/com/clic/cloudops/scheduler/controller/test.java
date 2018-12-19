package com.clic.cloudops.scheduler.controller;

import com.clic.cloudops.scheduler.model.Area;
import com.clic.cloudops.scheduler.service.showTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {
    @Autowired
    showTestService showTestservice;
    @RequestMapping("test")
    public List<Area> test1(){
        return showTestservice.showAll();
    }
}
