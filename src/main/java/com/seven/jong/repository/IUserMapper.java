package com.seven.jong.repository;

import com.seven.jong.VO.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface IUserMapper {

    void addUser(UserVO user);

    UserVO getUser(String email);

    UserVO getUser(Integer user_id);

    ArrayList<UserVO> getUsers();

    //모든 유저 수
    int selectUserCount();
    
    //모든 유저 정보
    ArrayList<UserVO> userInfo();
    
    //요청 페이지 유저 정보 리스트
    public ArrayList<UserVO> pageUserInfo(@Param("s") int start,@Param("e") int end);
    
    //요청 유저 정보
    UserVO info(int userId);

    //userId에 해당하는 유저 정보 update
	void updateUserInfo(@Param("userId")int userId, @Param("name")String name, @Param("birth")String birth, @Param("phone")int phone );

	//유저검색
	ArrayList<UserVO> userSearchList(@Param("s")int start, @Param("e") int end, @Param("c") String c, @Param("search") String search);
	
	//조건에 맞는 유저 수
	int selectSearchUserCount(@Param("c") String c, @Param("search") String search);

	

}
