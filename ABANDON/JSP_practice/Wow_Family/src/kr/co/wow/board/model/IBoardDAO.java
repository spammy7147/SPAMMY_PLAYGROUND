package kr.co.wow.board.model;

import java.util.List;

public interface IBoardDAO {

	// 글등록
	void boardAdd(String writer, String title, String content);
	
	
	// 글삭제
	void boardDel(int bId);
	
	// 글수정
	void boardFix(int bId);
	
	// 글목록
	List<BoardVO> boardList();
	
	// 글내용보기
	BoardVO boardContent(int bId);
	
	
	
}
