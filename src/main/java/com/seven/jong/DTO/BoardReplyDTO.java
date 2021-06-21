package com.seven.jong.DTO;

import java.sql.Timestamp;

public class BoardReplyDTO {
	private String reply_num;
	private String writer;
	private String content;
	private int write_group;
	private Timestamp write_date;
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWrite_group() {
		return write_group;
	}
	public void setWrite_group(int write_group) {
		this.write_group = write_group;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public String getReply_num() {
		return reply_num;
	}
	public void setReply_num(String reply_num) {
		this.reply_num = reply_num;
	}

	
}
