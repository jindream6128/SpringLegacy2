package com.bit.dao;

import com.bit.dto.BitDemoDTO;

import java.util.List;

public interface BitDemoDao {
    public void bitDemoInsert(BitDemoDTO dto);

    public List<BitDemoDTO> selectdata();
    public String getPass(String id); // id로 비밀번호 찾기
}
