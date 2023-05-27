package com.bit.controller;

import com.bit.dto.UserDto;
import com.bit.service.BitDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.CookieGenerator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login") //로그인에 관한건 여기서 처리하게 url만들고, 여기서 데이터 처리하기
public class LoginController {

    @Resource(name = "bitDemoServiceImp") //앞에 소문자로해야 받을수 있음
    BitDemoService service;

    @ResponseBody //이게 깡통 jsp 파일 안만들고 -> 바로 처리가능하게끔 사용하는 어노테이션 JSON텍스트를 반환할 수 있다.
    @PostMapping(value = "/logincheck", produces = "application/text; charset=utf-8;") //produce는 -> 메소드가 반환하는 타입의 인코딩 타입이다
    public String logincheck(String user_id, String user_passwd,String checker, HttpSession session, HttpServletResponse response){
        //쿼리로 바로 해당 회원이 있는지 확인하기 닉네임을 가져옴
        String result = service.loginCheck(new UserDto(user_id,user_passwd));

        session.setAttribute("id",user_id);
        //리턴은 해당하는 id pass의 닉네임 이다.

        //아이디 저장 checker 의 체크여부 확인하고, 체크되어있다면 쿠키에 아이디 넣기
        CookieGenerator c = new CookieGenerator();
        c.setCookieName("cookie_id");

        if(checker != null){
            c.addCookie(response,user_id);
        }else{
            c.removeCookie(response);
        }

        if(result == null) return "fail";

        return result;
    }

}
