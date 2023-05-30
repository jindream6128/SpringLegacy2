package com.bit.dao;

import com.bit.dto.EmpDTO;

import java.util.HashMap;
import java.util.List;

public interface MvcOptionDao {
    public List<EmpDTO> selectEmpList(HashMap<String,Object> map);
    public void deleteEmpList(List<Object> list);
}
