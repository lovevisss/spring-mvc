package com.zufedfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @RequestMapping("/testRequestByModelMap")
    public String ModelMapApi(ModelMap model){
//        使用ModelMap 向request域中存值
        model.addAttribute("requestScope","textModelMap");
        return "test";
    }

    @RequestMapping("/testSessionByServlet")
    public String testSessionByServlet(HttpServletRequest request){
//        使用servlet API 向session域中存值
        request.getSession().setAttribute("sessionScope","textSessionScope");
        return "test";
    }

    @RequestMapping("/testApplicationByServlet")
    public String testApplicationByServlet(HttpServletRequest request){
//        使用servlet API 向application域中存值
        request.getSession().getServletContext().setAttribute("applicationScope","textApplicationScope");
        return "test";
    }


}
