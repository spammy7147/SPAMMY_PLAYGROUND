package com.seven.jong.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface QnaFileService {
	public static final String IMAGE_REPO = "c:/spring/image_repo";
	
	String saveFile(MultipartFile file);

	String getMessage(int num, HttpServletRequest request);

	

}
