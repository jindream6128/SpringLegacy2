package com.bit.service;

import com.bit.dto.BitDemoDTO;

import java.util.List;

public interface BitDemoService {
    public void BitDemoInsert(BitDemoDTO dto);
    public List<BitDemoDTO> selectdata();
    public String getPass(String id); // id로 비밀번호 찾기
}
