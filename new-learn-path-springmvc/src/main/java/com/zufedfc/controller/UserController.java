package com.zufedfc.controller;

import com.zufedfc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class UserController {

    //write a controller route for jsp index
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/delete/{id}/{name}")
    public String delete(@PathVariable("id") Integer id, @PathVariable("name") String name){
        System.out.println("delete id = " + id + ",name = " + name);
        return "user/index";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String id = request.getParameter("id");

        System.out.println("testServlet"+"name = " + name + ",id = " + id);
        return "user/index";
    }

    @RequestMapping("/testForward")
    public String testForward(
            @RequestParam(value = "Name", required = false, defaultValue = "xiaoming") String name,
            String id,
            String[] hobby,
            @RequestHeader(value = "User-Agent", required = false, defaultValue = "chrome") String userAgent
    ){
        System.out.println("testForward"+"name = " + name + ",id = " + id + ",hobby = " + Arrays.toString(hobby) + ",userAgent = " + userAgent );
        return "user/index";
    }

//    user.create
    @RequestMapping("/create")
    public String create(){
        return "user/create";
    }

    @PostMapping("/testPOJO")
    public String testPOJO(User user){
        System.out.println("testPOJO"+"user = " + user.toString());
        return "user/index";
    }







}
