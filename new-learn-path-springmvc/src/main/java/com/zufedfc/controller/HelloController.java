package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    // "/" --> /WEB-INF/thymeleaf/index.html
    @RequestMapping ("/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping ("/test")
    public String hello(){
        //返回视图名称
        return "test";
    }

    @RequestMapping ("/target")
    public String target(){
        //返回视图名称
        return "target";
    }

}
