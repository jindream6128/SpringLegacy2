package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//디스패처 서블릿에 등록되어있어서 사용가능하다 컨트롤러로
@Controller
public class MvcLocationController {
    //여기서 매핑시켜줄때 -> value값이 완전히 일치해야하는거같은데? -> /web/app/mvcApp -> app/mvcApp을하면 안된다 -> **/app/mvcApp로 해야한다.
    @GetMapping(value = "app/mvcApp")
    public String mvcApp() {
        return "mvcLocation/mvcAppView"; //포워드랑은 다르다!
        //return "redirect:/mvcAppView"; //redirect 를 하면 디스패처를 안타겠다. -> 이렇게하면 localhost:8080/mvcAppView로 다이렉트로 찍힌다
        //return "redirect:mvcAppView.jsp"; //redirect 를 하면 디스패처를 안타겠다. -> 이렇게하면 http://localhost:8080/web/app/mvcAppView 로 다이렉트로 찍힌다
        //return "redirect:/web/app/mvcTest"; //이렇게 리다이렉트를 하면 다시 GetMapping을 시켜서
        //리다이렉트 할때는 .jsp도 해주어야한다 -> 디스패처 서블릿을 타지 않기 때문에! -> 근데 애초에 WEB-INF안에있는 것들은 직접적으로 url을 통해서 접근할 수 없다.
        //우리가 했던 예시를 생각해보면 -> 리스트에서 게시글에 들어간다 그러면 결국 list -> info 로 가야한다
        //그과정에서 hit가 늘어나려면 hit컨트롤러를 거쳐주고 다시 jsp로 가듯이.
    }

/*    @GetMapping(value = "mvcTest")
    public String mvcTest(){
        return "mvcLocation/mvcAppView";
    }*/

    @GetMapping(value = "app/salgrade")
    public String salgrade(){
        return "mvcLocation/salgradeView";
    }

}
