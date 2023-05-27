package com.bit.service;

import com.bit.dto.BitDemoDTO;
import com.bit.dto.UserDto;

import java.util.List;


public interface BitDemoService {
    //로그인하기 체크하기 -> id pass로 null인지 아닌지 바로 가져오기 -> null이면 해당하는게 없는거고, null아니면 해당하는게 있는거다
    public String loginCheck(UserDto userdto);


}
