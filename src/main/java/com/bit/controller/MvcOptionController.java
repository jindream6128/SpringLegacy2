package com.bit.controller;

import com.bit.dto.EmpDTO;
import com.bit.service.MvcOptionService;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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

}
