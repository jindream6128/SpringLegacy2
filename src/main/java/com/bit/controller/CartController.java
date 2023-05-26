package com.bit.controller;

import com.bit.service.BitDemoService;
import com.bit.dto.BitDemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Resource(name = "bitDemoServiceImp")
    private BitDemoService service;

    @GetMapping(value = "cart/Login")
    public String adminLogin(){
        return "cart/adminLogin";
    }

    //로그인확인하기
    @PostMapping(value = "/cartloginchk")
    public String cartloginchk(String user_id, String user_passwd, HttpSession session){

        String dbPass = service.getPass(user_id);

        if(dbPass!=null && dbPass.equals(user_passwd)){
            session.setAttribute("id",user_id);
            session.setMaxInactiveInterval(10000);
            return "redirect:/productList";
        }
        //로그인에 실패하면 다시 로그인창으로
        return "cart/adminLogin";
    }

    //로그인에 성공하면, productList로 이동한다
    @GetMapping(value = "/productList")
    public String  processAllProduct(HttpSession session){
        //System.out.println(session.getAttribute("id"));
        return "cart/productAdd";
    }

    @PostMapping(value = "/addproduct")
    public String addproduct(){

        return "cart/productAdd";
    }

    @PostMapping(value="/cartList")
    public String test(){
        return "cart/cartList";
    }

    @GetMapping(value = "cart/Start")
    public String list(){
        return "cart/cartList";
    }

    //이건 나중에쓰기
    public List<BitDemoDTO> selectdata(){

        return service.selectdata();
    }








}
