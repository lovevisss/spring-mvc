package com.zufedfc.controller;

import com.zufedfc.bean.Employee;
import com.zufedfc.dao.EmployDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployDao employDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getALl(Model model){
        Collection<Employee> employees = employDao.getAll();
        model.addAttribute("emps", employees);
        return "list";
    }
//    delete
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable  Integer id){
        employDao.delete(id);
        return "redirect:/employee";
    }



//    add user
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String add(Employee employee){
        employDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Integer id, Model model){
        Employee employee = employDao.get(id);
        model.addAttribute("emp", employee);
        return "update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String update(Employee employee){
        employDao.save(employee);
        return "redirect:/employee";
    }





}
