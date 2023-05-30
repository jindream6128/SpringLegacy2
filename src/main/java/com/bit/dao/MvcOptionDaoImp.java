package com.bit.dao;

import com.bit.dto.EmpDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MvcOptionDaoImp implements MvcOptionDao{
    static String nameSpace = "com.bit.dto.mvcMapper.";

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<EmpDTO> selectEmpList(HashMap<String, Object> map) {
        return sqlSession.selectList(nameSpace+"selectEmpList", map);
    }

    @Override
    public void deleteEmpList(List<Object> list) {
        sqlSession.delete(nameSpace+"deleteEmpList", list);
    }
}
