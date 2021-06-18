package com.seven.jong.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.BoardReplyDTO;

public interface BoardService {
	public void writeSave(BoardDTO dto,HttpServletRequest request);
	public void boardAllList(Model model, int num);
	public void contentView (int writeNo, Model model );
	public void modify(BoardDTO dto, HttpServletRequest request);
	public void delete(int writeNo);
	public void boardSearch(int num, String choice, String search, Model model);
	public List<BoardReplyDTO> getReplyList(int write_group);
	public void addReply(String content, int writeNo, String writer);

}
