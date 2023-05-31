package com.bit.controller;

import com.bit.service.MvcOptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class MvcOption2Controller {

    @Resource(name="mvcOptionServiceImp")
    private MvcOptionService mvcOptionService;


   @GetMapping(value = "header1")
    public String processOption1(@RequestHeader("Host")String host,
                                 @RequestHeader("Accept")String acceptyType,
                                 @RequestHeader("User-Agent")String userAgent,
                                 Model model){
       model.addAttribute("Host" ,host);
       model.addAttribute("Accept" ,acceptyType);
       model.addAttribute("User-Agent" ,userAgent);

       return "mvcAjaxView/resultOption1";
   }

    @GetMapping(value = "header2")
    public String processOption2(@RequestHeader Map<String,String>map,
            Model model){

        model.addAttribute("map",map);
        return "mvcAjaxView/resultOption1";
    }

    @GetMapping(value = "nullpoint")
    public String exceptionMake1(Model model){
       String str = null;
       str.charAt(0);
       model.addAttribute("message","nullPoint");

       return "mvcAjaxView/resultException1";
    }

    @GetMapping(value = "classCast")
    public String exceptionMake2(Model model){
       String s = (String)new Object();
        model.addAttribute("message","classCast");
        return "mvcAjaxView/resultException1";
    }

    @GetMapping(value = "numberFormat")
    public String exceptionMake3(Model model){
       String str = null;
       Integer.parseInt(str);
        model.addAttribute("message","numberFormat");
        return "mvcAjaxView/resultException1";
    }

   /* @ExceptionHandler(NullPointerException.class)
    public ModelAndView processException1(NullPointerException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mvcAjaxView/exceptionView");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }

    @ExceptionHandler(ClassCastException.class)
    public ModelAndView processException2(ClassCastException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mvcAjaxView/exceptionView");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView processException3(NumberFormatException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mvcAjaxView/exceptionView");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }*/


}
