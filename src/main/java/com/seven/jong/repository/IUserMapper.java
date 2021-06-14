package com.seven.jong.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.UserReponseDTO;
import com.seven.jong.VO.UserVO;


public interface IUserMapper {

    void addUser(UserVO user);
    
    //모든 유저 수
    int selectUserCount();
    
    //모든 유저 정보
    ArrayList<UserVO> userInfo();
    
    //요청 페이지 유저 정보
    public ArrayList<UserReponseDTO> pageUserInfo(@Param("s") int start,@Param("e") int end);

	UserVO info(int member_id);

	
}
