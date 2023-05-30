package com.bit.service;

import com.bit.dao.MvcOptionDao;
import com.bit.dao.MvcOptionDaoImp;
import com.bit.dto.EmpDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MvcOptionServiceImp implements MvcOptionService{

    @Resource(name = "mvcOptionDaoImp")
    private MvcOptionDao dao;


    @Override
    public List<EmpDTO> selectEmpList(Map<String, Object> map) {
            return dao.selectEmpList((HashMap<String, Object>) map);
    }

    @Override
    public void deleteEmpList(List<Object> list) {
        dao.deleteEmpList(list);
    }
}
