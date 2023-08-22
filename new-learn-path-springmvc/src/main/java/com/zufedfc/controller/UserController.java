package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //write a controller route for jsp index
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
