package com.seven.jong.repository.user;

import com.seven.jong.VO.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface IUserMapper {

    //유저 추가
    void addUser(UserVO user);
    //ID로 유저 검색
    UserVO getUserById(Integer user_id);
    //email(아이디)로 유저검색
    UserVO getUserByEmail(String email);
    //모든유저 가져오기
    ArrayList<UserVO> getUsers();
    // 유저 수정
    void updateUser(UserVO user);
    
    //유저 비활성화
    int stopUser(Integer user_id);
    
    //유저 활성화
    int startUser(Integer user_id);
    
    // 유저 삭제
    void deleteUser(Integer UserId);
    int delete(int userId);
    
    //모든 유저 수
    int selectUserCount();

    //요청 페이지 유저 정보 리스트
    public ArrayList<UserVO> pageUserInfo(@Param("s") int start,@Param("e") int end);

	//유저검색
	ArrayList<UserVO> userSearchList(@Param("s")int start, @Param("e") int end, @Param("c") String c, @Param("search") String search);
	
	//조건에 맞는 유저 수
	int selectSearchUserCount(@Param("c") String c, @Param("search") String search);
	
	

	

}
