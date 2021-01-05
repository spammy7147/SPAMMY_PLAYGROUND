package kr.co.wow.user.model;

public interface IUserDAO {

	// 유저 입력
	void userAdd(String id);
	
	// 유저 삭제
	void userDel(String id);
	
	// 유저 수정(아이디, 비밀번호 제외)
	void userChange(UserVO vo);
	
	// 유저 검색
	void userSearch(String id);
	
	
	// 유저 비밀번호 변경
	void userPwChange(String id);
	
	// 유저 로그인 유효성 검사
	int userCheck(String id, String pw);
	
	//중복 ID 여부를 검증하는 메서드
	boolean confirmId(String id);
	
}
