package com.bit.controller;

import com.bit.service.BitDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CartPageController {
    @Resource(name = "bitDemoServiceImp")
    private BitDemoService service;

    //시작할때
   @GetMapping(value = "**/productList")
    public String goProductList(){
       return "cart/productList";
   }

   //로그인하면 로그인페이지 가기
   @GetMapping(value = "login")
    public String goLogin(Model model, @CookieValue(value="cookie_id", required = false)String cookie_id){
       //쿠키에 아이디가 존재한다면
       if(cookie_id != null){
           model.addAttribute("cookie_id",cookie_id);
       }
        return "cart/adminLogin";
   }


   //로그아웃 세션지우기
   @GetMapping(value = "logout")
    public String goLogout(HttpSession session){
       session.removeAttribute("id");
       return "cart/productList";
   }

    //추가 페이지로 이동하기
    @GetMapping(value = "add")
    public String goAdd(){
       return "cart/productAdd";
    }

}
