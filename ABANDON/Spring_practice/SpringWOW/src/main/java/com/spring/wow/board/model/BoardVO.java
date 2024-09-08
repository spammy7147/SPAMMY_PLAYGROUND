package com.spring.wow.board.model;

import java.util.Date;

public class BoardVO {
	
	private Integer BoardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Integer viewCnt;
	
	//신규 게시물에 new 마크를 붙일지 말지 결정하는 논리필드
	private boolean newMark;
	
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	public boolean isNewMark() {
		return newMark;
	}
	
	
	public Integer getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(Integer boardNo) {
		BoardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [BoardNO=" + BoardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", viewCnt=" + viewCnt + "]";
	}
	
}
