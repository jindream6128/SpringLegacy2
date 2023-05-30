package com.bit.service;

import com.bit.dto.EmpDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MvcOptionService {
    public List<EmpDTO> selectEmpList(Map<String, Object> map);
    public void deleteEmpList(List<Object> list);
}
