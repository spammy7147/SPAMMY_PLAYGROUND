package com.seven.jong.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private int writeNo;
	private String writer;
	private String title;
	private String content;
	private String saveDate;
	private int hit;
}
