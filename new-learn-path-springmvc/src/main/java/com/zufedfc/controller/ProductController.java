package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {


    @RequestMapping("/list")
    public String list(){
        //返回视图名称
        return "product/list";
    }

    @RequestMapping(
            value = {"/add", "/addone"}
    )
    public String add(){
        //返回视图名称
        return "product/add";
    }

    @RequestMapping(value = "/update" , method = {RequestMethod.PUT})
    public String update(){
        //返回视图名称
        return "product/update";
    }

    @GetMapping("/create")
    public String create(){
        return "product/create";
    }



}
