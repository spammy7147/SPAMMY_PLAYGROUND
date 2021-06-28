package com.seven.jong.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class BoardFileServiceImpl implements BoardFileService {

	@Override
	public String saveFile(MultipartFile file) {
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
		String sysFileName =
				simpl.format(calendar.getTime()) + file.getOriginalFilename();
		File saveFile = new File(Board_IMAGE_REPO+"/"+sysFileName);
		try {
			file.transferTo(saveFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}

}
