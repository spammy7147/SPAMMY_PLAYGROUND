package com.seven.jong.service;

import org.springframework.web.multipart.MultipartFile;

import com.seven.jong.DTO.MessageDTO;

public interface BoardFileService {
	public static final String Board_IMAGE_REPO = "c:/spring/board_image_repo";
	
	//이미지 저장
	String saveFile(MultipartFile file);
	//이미지 삭제
	void deleteImage(String imageFileName);
	//메세지 & 경로
	String getMessage(MessageDTO dto);

}
