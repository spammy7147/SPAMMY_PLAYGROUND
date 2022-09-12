package kr.co.wow.board.model;

import java.sql.Timestamp;

public class BoardVO {
	
	
	
	
	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Timestamp createAt;
	private int hit;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int boardId, String writer, String title, String content, Timestamp createAt, int hit) {
		super();
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createAt = createAt;
		this.hit = hit;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
	
	

}















