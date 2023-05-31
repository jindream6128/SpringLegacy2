package com.bit.controller;


import com.bit.dto.TestDTO;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//이건 @ResponseBody랑 같은거
@org.springframework.web.bind.annotation.RestController
public class RestController {

    //RestController 는 -> ResponseBody 를 가지고 있음
    @PostMapping(value = "/ajaxTest5")
    public String ajaxTestProcess5(){
        return "Success RestController";
    }

    @PostMapping(value = "/ajaxTest6")
    public TestDTO ajaxTestProcess6(){
        return new TestDTO("kim", "busan", 1000);
    }

    @PostMapping(value = "/ajaxTest7")
    public HashMap<Integer,TestDTO> ajaxTestProcess7(){
        HashMap<Integer,TestDTO> map = new HashMap<>();
        map.put(1,new TestDTO("kim","busan",1));
        map.put(2,new TestDTO("kim2","busan2",2));
        map.put(3,new TestDTO("kim3","busan3",3));
       return map;
    }

    @PostMapping(value = "/ajaxTest8")
    public List<HashMap<Integer,TestDTO>> ajaxTestProcess8(){
        HashMap<Integer,TestDTO> map = new HashMap<>();
        ArrayList<HashMap<Integer,TestDTO>> list = new ArrayList<>();
        map.put(1,new TestDTO("kim","busan",1));
        map.put(2,new TestDTO("kim2","busan2",2));
        map.put(3,new TestDTO("kim3","busan3",3));
        list.add(map);
        return list;
    }
}
