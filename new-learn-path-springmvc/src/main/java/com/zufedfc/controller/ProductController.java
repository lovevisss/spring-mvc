package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {


    @RequestMapping("/list")
    public String list(){
        //返回视图名称
        return "product/list";
    }
}
