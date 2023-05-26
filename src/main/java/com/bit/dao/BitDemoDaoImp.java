package com.bit.dao;

import com.bit.dto.BitDemoDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //DB 에서 관리 @repository -> @component -> 컴포넌트 스캔필요
public class BitDemoDaoImp implements BitDemoDao{
    @Autowired
    private SqlSessionTemplate sqlSession;
    private String nameSpace ="com.bit.dto.basicMapper";

    @Override
    public String getPass(String id) {
        return sqlSession.selectOne(nameSpace+".getPass",id);
    }

    @Override
    public void bitDemoInsert(BitDemoDTO dto) {

        //여기서는 오히려 rollback 이나 commit을 하면 오류가 날수도 있다.
        sqlSession.insert(nameSpace+".insertdata",dto);

      /*dto.setName(dto.getName().concat("Update"));
      sqlSession.update(nameSpace+".bitDemoUpdate",dto);*/
    }

    @Override
    public List<BitDemoDTO> selectdata() {

        return sqlSession.selectList(nameSpace+".selectdata");
    }


}
