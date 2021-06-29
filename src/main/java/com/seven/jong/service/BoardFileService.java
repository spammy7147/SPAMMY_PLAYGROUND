package com.seven.jong.service;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public static final String Board_IMAGE_REPO = "c:/spring/board_image_repo";
	
	String saveFile(MultipartFile file);

}
