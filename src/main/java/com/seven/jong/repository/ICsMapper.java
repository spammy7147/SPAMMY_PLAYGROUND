package com.seven.jong.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.QnaRepDTO;

public interface ICsMapper {
	
	//자주하는 질문 모든 정보
	public ArrayList<FaqDTO> faqList();
	
	//자주하는 질문 추가
	public void addFaq(FaqDTO dto);

	//자주하는 질문 삭제
	public void delFaq(int faqNum);
	
	
	// 총 qna 갯수
	public int selectQnaCount();
		
	//qna 요청 페이지 정보
	public ArrayList<QnaDTO> pageQnaInfo(@Param("s") int start,@Param("e") int end);
	
	//조회수 올리기
	public void upHit(int qnaNo);

	//QnA저장
	public int qnaSave(QnaDTO dto);
	
	//선택 QnA 컨텐츠 가져오기
	public QnaDTO qnaContentView(int qnaNo);

	//QnA 삭제
	public int qnaDelete(int qnaNo);

	//QnA 수정
	public int modify(QnaDTO dto);
	
	//QnA 추가
	public void addReply(QnaRepDTO dto);

	//QnA 선택 content의 리플 가져오기
	public ArrayList<QnaRepDTO> getRepList(int write_group);
	
}
