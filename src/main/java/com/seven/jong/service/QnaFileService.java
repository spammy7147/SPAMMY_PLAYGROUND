package com.seven.jong.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.seven.jong.DTO.MessageDTO;

public interface QnaFileService {
	public static final String IMAGE_REPO = "c:/spring/image_repo";
	
	String saveFile(MultipartFile file);
	//QnA 이미지 삭제
	void deleteImage(String imageFileName);
	//메세지 & 경로
	String getMessage(MessageDTO dto);

	

}
