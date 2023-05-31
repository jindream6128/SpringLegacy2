package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceException {

    //이거쓰면 한번에 잡아준다
    @ExceptionHandler(Exception.class)
    public ModelAndView processException2(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mvcAjaxView/exceptionView");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
}
