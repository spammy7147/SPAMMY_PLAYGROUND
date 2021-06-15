package com.seven.jong.repository;

import java.util.ArrayList;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;


public interface IUserMapper {

    void addUser(UserVO user);

    UserVO getUser(String email);

    UserVO getUser(Integer user_id);

    ArrayList<UserVO> getUsers();


}
