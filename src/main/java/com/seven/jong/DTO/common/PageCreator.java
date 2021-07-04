package com.seven.jong.DTO.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@Setter
@Getter
@ToString
public class PageCreator {

    private PageDTO paging;
    private Integer articleTotalCount; // 게시판의 총게시물 수
    private Integer beginPage; // 시작 페이지 번호
    private Integer endPage; // 끝페이지 번호
    private boolean prev; //이전 버튼 활성화 여부
    private boolean next; //다음 버튼 활성화 여부
    private final Integer displayPageNum = 5;


    //페이징 알고리즘을 수행할 메서드 선언 => setArticleTotalCount() 메서드에서 호출
    private void calcDataOfPage() {
        //보정 전 끝 페이지 구하기
        endPage = (int) (Math.ceil(paging.getPage() / (double)displayPageNum ) * displayPageNum);
        //시작 페이지 번호 구하기
        beginPage = (endPage - displayPageNum) +1;
        // 현재 시작페이지가 1이라면 이전 버튼 활성화 여부를 false로 지정
        prev = beginPage != 1;
        //마지막 페이지인지 여부 확인 후 다음 버튼 활성화
        next = articleTotalCount > endPage * paging.getCountPerPage();
        //재보정 여부 판단하기
        //끝페이지 재보정하기
        if(!isNext()) {
            endPage = (int)Math.ceil(articleTotalCount / (double)paging.getCountPerPage());
        }
    }
    public void setArticleTotalCount (Integer articleTotalCount) {
        this.articleTotalCount = articleTotalCount;
        calcDataOfPage();
    }
    //URI 파라미터를 쉽게 만들어주는 유틸 메서드 선언
    public String makeURI(Integer page) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("countPerPage", paging.getCountPerPage())
                .queryParam("keyword", ((SearchDTO)paging).getKeyword())
                .queryParam("condition", ((SearchDTO)paging).getCondition())
                .build().toString();
    }

}
