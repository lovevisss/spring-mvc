package com.zufedfc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String error(Exception e, Model model){
        model.addAttribute("ex", e.getMessage());
//        e.printStackTrace();
        return "error";
    }


}
