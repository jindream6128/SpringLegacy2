package com.bit.controller;

import com.bit.dto.EmpDTO;
import com.bit.dto.TestDTO;
import com.bit.service.MvcOptionService;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MvcOptionController {

    @Resource(name="mvcOptionServiceImp")
    private MvcOptionService mvcOptionService;


    @GetMapping(value ="pathParam/EmpSelect")
    public String selectEmpEnameListParamEmpty(Model model) {
        model.addAttribute("empList", mvcOptionService.selectEmpList(null));
        return "/mvcOptionViews/empViewSyn";
    }

    @GetMapping(value = "pathParam/EmpSelect/{ENAME}")
//    public String selectEmpList(@PathVariable("ename")String ename,@PathVariable("job")String job){
   public String selectEnameList(@PathVariable Map<String,Object>pathMap, Model model){
   // public String selectEnameList(@PathVariable EmpDTO dto){


        model.addAttribute("empList",mvcOptionService.selectEmpList(pathMap));
        return "/mvcOptionViews/empViewSyn";
    }

    @GetMapping(value = "pathParam/EmpSelect/{ENAME}/{JOB}")
//    public String selectEmpList(@PathVariable("ename")String ename,@PathVariable("job")String job){
        public String selectEmpList(@PathVariable Map<String,Object>pathMap, Model model){
        //public String selectEmpList(@PathVariable EmpDTO dto){


        model.addAttribute("empList",mvcOptionService.selectEmpList(pathMap));
        return "/mvcOptionViews/empViewSyn";
    }

    @PostMapping(value = "deleteCheck")
    public String deleteEMP(@RequestParam (value = "empnoCh", required = false)List<Object> empnoch, Model model){
        System.out.println("--------------------------------deleteCheck");

        //HashMap<String,Object>map=new HashMap<String,Object>();
      //  System.out.println(list);
     //   map.put("empnoch",empnoch);
        mvcOptionService.deleteEmpList(empnoch);

        model.addAttribute("empList", mvcOptionService.selectEmpList(null));
        return "/mvcOptionViews/empViewSyn";
    }

    //AjaxTest
    @RequestMapping(value = "ajaxTest1", method = RequestMethod.POST) //-> POST라고 쓰면 POST GET이면 GET , 메소드 안쓰면 보내는데로 받는게 RequestMapping
    public String ajaxTestProcess1(Model model){
        model.addAttribute("ajax1","AjaxTest1");
        return "/mvcAjaxView/resultajaxMvc1";
    }

    @RequestMapping(value = "ajaxTest2", method = RequestMethod.POST) //-> POST라고 쓰면 POST GET이면 GET , 메소드 안쓰면 보내는데로 받는게 RequestMapping
    public String ajaxTestProcess2(Model model,@RequestBody HashMap<String,Object>map){ // @RequestBody json을 자바로 받아주는 부분
        model.addAttribute("ajax1",map);
        return "/mvcAjaxView/resultajaxMvc1";
    }

    @ResponseBody
    @RequestMapping(value = "ajaxTest3", method = RequestMethod.POST) //-> POST라고 쓰면 POST GET이면 GET , 메소드 안쓰면 보내는데로 받는게 RequestMapping
    public List<EmpDTO> ajaxTestProcess3(Model model, @RequestBody HashMap<String,Object>map){ // @RequestBody json을 자바로 받아주는 부분
        return mvcOptionService.selectEmpList(null);
    }

    @ResponseBody
    @RequestMapping(value = "ajaxTest4", method = RequestMethod.POST) //-> POST라고 쓰면 POST GET이면 GET , 메소드 안쓰면 보내는데로 받는게 RequestMapping
    public ArrayList<TestDTO> ajaxTestProcess4(Model model, @RequestBody TestDTO dto){ // @RequestBody json을 자바로 받아주는 부분
        ArrayList<TestDTO> list = new ArrayList<>();
        list.add(dto);
        return list;
    }

/*    @ResponseBody
    @RequestMapping(value = "ajaxTest5", method = RequestMethod.POST) //-> POST라고 쓰면 POST GET이면 GET , 메소드 안쓰면 보내는데로 받는게 RequestMapping
    public String ajaxTestProcess5(Model model, @RequestBody TestDTO dto){ // @RequestBody json을 자바로 받아주는 부분
        ArrayList<TestDTO> list = new ArrayList<>();
        return "";
    }*/




}
