package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HttpController {

    @RequestMapping(value = "testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("reqeustBody: " + requestBody);
        return "success";
    }
}
