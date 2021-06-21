package com.seven.jong.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public class QnaFileServiceImpl implements QnaFileService {

	@Override
	public String getMessage(int num, HttpServletRequest request) {
		String message = null;
		if(num == 1) {
			message = "<script>alert('새글이 추가 되었습니다');";
			message += 
		"location.href='"+request.getContextPath()+"/cs/customerqna';</script>";
		}else {
			message = "<script>alert('문제가 발생했습니다!!!');";
			message += 
		"location.href='"+request.getContextPath()+"/cs/qnawriteform';</script>";
		}
		return message;
	}

	@Override
	public String saveFile(MultipartFile file) {
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
		String sysFileName =
				simpl.format(calendar.getTime()) + file.getOriginalFilename();
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		try {
			file.transferTo(saveFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}

}
