package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    /**
     * 使用restful风格
     * @return
     * /user GET 查询所有用户信息
     * /user POST 添加用户信息
     * /user/{id} GET 根据id查询用户信息
     * /user/{id} PUT 根据id修改用户信息
     * /user/{id} DELETE 根据id删除用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAll_User(){
        System.out.println("all user info");
        return "test";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getuserById(@PathVariable Integer id){
        System.out.println("user info" + id);
        return "test";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String adduser(String username, String password){
        System.out.println("add user :" + username + "," + password);
        return "test";
    }




    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateuserById(@PathVariable Integer id){
        System.out.println("update user:" + id);
        return "test";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteuserById(@PathVariable Integer id){
        System.out.println("delete user:" + id);
        return "test";
    }





}
