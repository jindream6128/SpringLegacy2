package com.bit.service;

import com.bit.dao.BitDemoDao;
import com.bit.dto.BitDemoDTO;
import com.bit.dto.UserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BitDemoServiceImp implements BitDemoService{

    //이렇게 인터페이스를 가지고 있는것이 -> 루즈커플링
    //@Autowired //가능
    @Resource(name="bitDemoDaoImp")
    private BitDemoDao dao;

    @Override
    public String loginCheck(UserDto userdto) {
        return dao.loginCheck(userdto);
    }




}
