package com.spring.wow.board.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.wow.board.model.BoardVO;
import com.spring.wow.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {

	@Autowired
	private IBoardMapper mapper;

	//게시글 등록 테스트
	@Test
	public void insertTest() {
		
		for(int i =1; i<=320; i++) {
			BoardVO article = new BoardVO();
			article.setTitle("제목입니다" + i);
			article.setWriter("테스트" + i);
			article.setContent("테스트중입니다" + i);
			mapper.insert(article);
			System.out.println("게시글 등록 성공!");
		}
	}
	
	
	//게시글 목록 조회 테스트
	@Test
	public void getListTest() {
//		List<BoardVO> list = mapper.getArticleList();
//		for (BoardVO vo : list) {
//			System.out.println(vo);
		
		mapper.getArticleList().forEach(vo -> System.out.println(vo));
		}
	
	//게시글 단일 목록 조회 테스트
	@Test
	public void getArticleTest() {
		System.out.println(mapper.getArticle(300).toString());
		
	}

	//게시글 수정 조회 테스트
	@Test
	public void updateTest() {
		BoardVO article = mapper.getArticle(300);
		article.setTitle("수정한 300번째 게시글");
		article.setContent("300번쨰 개시글 수정");
		mapper.update(article);
	}
	
	@Test
	public void deleteTest() {
		for(int i=1; i<300; i++) {
			mapper.delete(i);
			System.out.println(i + "번 번호 삭제");
		}
		
	}
	



}
