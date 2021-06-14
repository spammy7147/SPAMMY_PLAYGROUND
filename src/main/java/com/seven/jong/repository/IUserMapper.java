package com.seven.jong.repository;

import java.util.ArrayList;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;


public interface IUserMapper {

    void addUser(UserVO user);
    
    ArrayList<UserVO> userInfo();

	UserVO info(int member_id);
}
