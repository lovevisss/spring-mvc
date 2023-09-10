package com.zufedfc.controller;

import com.zufedfc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    @RequestMapping(value = "testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("reqeustBody: " + requestBody);
        return "success";
    }

    @RequestMapping(value = "testRequestEntity", method = RequestMethod.POST)
    public String testRequestBody2(RequestEntity<String> requestBody) {
        System.out.println("Header: " + requestBody.getHeaders());
        System.out.println("reqeustBody: " + requestBody.getBody());
        return "success";
    }

//    @ResponseBody
    @RequestMapping(value = "testResponseEntity")
    public void testResponseEntity(HttpServletResponse response) throws IOException {
       response.getWriter().print("hello, response");
    }

    @RequestMapping(value = "testResponseEntity2")
    @ResponseBody
    public String testResponseEntity2() {
        return "successful";
    }

    @RequestMapping(value = "testResponseEntity3")
    @ResponseBody
    public User testResponseEntity3() {
//        convert to json
        return new User(1, "zufedfc", "dfc@qq.com", 18);
    }

//    test ajax
    @RequestMapping(value = "testAjax")
    @ResponseBody
    public String testAjax(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "successful";
    }
//    test exception
    @RequestMapping(value = "testException")
    public String testException() {
        int i = 10 / 0;
        return "success";
    }

}
