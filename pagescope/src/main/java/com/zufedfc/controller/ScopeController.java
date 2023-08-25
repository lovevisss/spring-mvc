package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testRequestByServlet")
    public String ServeletApi(HttpServletRequest request){
//        使用servlet API 向request域中存值
        request.setAttribute("requestScope","textRequestScope");


        return "test";
    }

    @RequestMapping("/testRequestByModelAndView")
    public ModelAndView ModelAndView(){
//        使用ModelAndView 向request域中存值
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("requestScope","textModelAndView");
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping("/testRequestByModel")
    public String ModelApi(Model model){
//        使用Model 向request域中存值
        model.addAttribute("requestScope","textModel");
        return "test";
    }

    @RequestMapping("/testRequestByMap")
    public String MapApi(Map<String , Object> map){
//        使用Map 向request域中存值
        map.put("requestScope","textMap");
        return "test";
    }


}
