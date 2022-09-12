package com.seven.jong.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.seven.jong.DTO.MessageDTO;


public class QnaFileServiceImpl implements QnaFileService {



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
	
	public void deleteImage(String imageFileName) {
		File file = new File(IMAGE_REPO+"/"+imageFileName);
		file.delete();
	}

	@Override
	public String getMessage(MessageDTO dto) {
		String message = null;
		String path = dto.getRequest().getContextPath();
		if(dto.getResult() == 1) {
			message = "<script>alert('"+dto.getSuccessMessage()+"');";
			message += "location.href='"+path+dto.getSuccessURL()+"'</script>";
		}else {
			message = "<script>alert('"+dto.getFailMessage()+"');";
			message += "location.href='"+path+dto.getFailURL()+"'</script>";
		}
		return message;
	}
}
