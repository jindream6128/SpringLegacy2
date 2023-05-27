package com.bit.dao;

import com.bit.dto.BitDemoDTO;
import com.bit.dto.UserDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //DB 에서 관리 @repository -> @component -> 컴포넌트 스캔필요
public class BitDemoDaoImp implements BitDemoDao{
    @Autowired
    private SqlSessionTemplate sqlSession;

    private String nameSpace ="com.bit.dto.basicMapper";
    private String userNameSpace = "com.bit.dto.userMapper"; //여기 이름은 그냥 마지막꺼만 맞추기 구분하기 위함임!

    @Override
    public String loginCheck(UserDto userdto) {
        //userNameSpace + xml에 사용된 이름
        return sqlSession.selectOne(userNameSpace+".loginCheck",userdto);
    }






}
