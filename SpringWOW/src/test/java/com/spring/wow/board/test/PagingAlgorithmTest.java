package com.spring.wow.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.wow.board.repository.IBoardMapper;
import com.spring.wow.commons.PageVO;
import com.spring.wow.commons.SearchVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class PagingAlgorithmTest {

	
	
	/*
	 
	 페이징 알고리즘 만들기
	 
	 #1. 사용자가 보게 될 페이지 화면
	 - 한 화면에 페이지를 10개씩 끊어서 보여준다면?
	 ex) 1 2 3 4 .. 9 10 [다음] //[이전] 31 32 33 .... 39 40 [다음]
	 
	 - 총 게시물수가 67개 라면?? // 이전 다음 비활성화
	 
	 
	 - 총개시물 수가 142 개이고 현재 12페이지에  사용자가 머물러있다면??
	 ex) [이전] 11 12 13 14 15 
	 
	 
	 #총 게시물의 수를 조회해야 합니다.
	 - 총 게시물 수는 DB로 부터 수를 조회하는 SQL을 작성
	 
	 #2. 우선 총 게시물의 수를 조회해야합니다
	 - 총 게시물 수는 DB로부터 수를 조회하는 SQL을 작성
	 
	 #3. 사용자가 현재 위치한 페이지를 기준으로 
	 끝페이지 번호를 계산하는 로직 작성
	 
	 - 만약 현재 사용자가 보고있는 페이지가 3페이지라고 한 화면에 
	 보여줄 페이지가 10페이지씩이라면??
	 -> 끝페이지 번호는 ?? 10페이지 
	 
	 
	 만약 현재 페이지가 37페이지고 한화면에 보여줄 게시글이 20페이지씩이라면
	 끝 페이지 번호는 ?? 40페이지
	 
	 끝페이지 공식
	 - 공식 : Math.cell(현재 위치한 페이지 번호 / 한화면당 보여질 게시글의 수) * 한화면당 보여질 게시글의 수
	 
	 #4. 시작페이지 번호 계산하기
	 - 현재 위치한 페이지가 15페이지고 한화면에 보여줄 페이지가 10페이지씩이라면 ??
	 -> 시작페이지 번호는 ?? 11페이지
	 
	 - 현재 위치한 페이지가 73페이지고, 한화면에 20페이지씩 보여준다면??
	 -> 시작페이지 번호는??? 61페이지
	 
	 -공식 : (끝페이지 번호 - 한화면에 보여줄 페이지 수)+1
	 
	 
	 #5. 끝페이지 보정
	 
	 -총 게시물 수가 349개이고 한페이지당 10개의 게시물을 보여준다
	 - 그리고 현재 이사람은 31페이지를 보고있다.
	 그렇다면 위 공식에 의한 끝페이지는 어떻게 계산되는가?? 40 페이지
	 
	 - 하지만 실제 끝페이지는 몇번이어야 하는가? 35페이지
	 
	 
	 
	 #5-1 이전버튼 활성 여부 설정 
	 - 언제 이전버튼을 비활성화 할것인가?? 시작페이지가 1인 부분에서 비활성
	 
	 -공식 : 시작페이지 번호가 1로 구해진 시점에서 비활성 처리, 나머지는 활성
	 
	 
	  #5-2 다음 버튼 활성 여부 설정
	 - 언제 다음 버튼을 비활성화 할것인가 
	 
	 공식 : 보정전 끝페이지 번호 * 한페이지에 들어갈 게시물 수  >= 총 게시물 수 -> 비활성
	 
	 
	 #5-3 : 끝 페이지 값 보정
	 - 다음 버튼이 비활성화 되었을 떄 총 게시물 수에 맞춰 끝페이지 번호를 재보정 한다.
	 
	 - 공식:  Maht.ceil( 총 게시물의 수 / 한페이지에 보여줄 게시물 수)
	 
	
	
	 */
	@Autowired
	private IBoardMapper mapper;

	
	@Test
	public void pagingAlgorithmTest() {
		System.out.println("=========");
		//System.out.println(mapper.countArticles());
		System.out.println("=========");
		
		//끝페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(33);
		int displayPage = 10;
		
		int endPage = (int)Math.ceil(paging.getPage() / (double)displayPage) * displayPage;
		System.out.println("끝페이지 번호 : " + endPage);
		
		//시작페이지 번호 계산 테스트
		int beginPage = (endPage - displayPage) + 1;
		System.out.println("시작페이지 번호 : " + beginPage);
		
		
		System.out.println("==========================================================");
		
		boolean isPrev = (beginPage == 1) ? false : true;
		System.out.println("이전 버튼 활성화 여부 : " + isPrev);
		System.out.println("========================================================");
		
		
		
		//끝 페이지 보정
		//int temp = (int)Math.ceil(mapper.countArticles() / (double)paging.getCountPerPage());
		
		
		//재보정 여부 판단하기 
		//if(endPage > temp) {
		//	endPage = temp;
		//}
		System.out.println("보정 후 끝페이지 번호 : " + endPage);
		
		
		
		//boolean isNext = (mapper.countArticles() <= (endPage * paging.getCountPerPage())) ? false : true;
		//System.out.println("다음 버튼 활성화 여부 : " + isNext);
		System.out.println("========================================================");
		
		
		
	}
	
	
	@Test
	public void searchTest() {
		SearchVO search = new SearchVO();
		search.setPage(1);
		System.out.println(search.getCountPerPage());
		search.setKeyword("4");
		System.out.println(search.getFirstPage()+ " : firstPage");
		System.out.println(search.getLastPage() + " : LastPage");
		
		System.out.println("===========================================");
		//mapper.getArticleListByTitle(search).forEach(vo -> System.out.println(vo));
		System.out.println("===========================================");
	}
	
	
	
}
