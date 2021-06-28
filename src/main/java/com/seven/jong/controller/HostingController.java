package com.seven.jong.controller;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hosting")
public class HostingController {

    @GetMapping("/address")
    public String address() {
        return "hosting/address";
    }

    @PostMapping("/address")
    public String address(AccommodationDTO hostingDTO) {
        System.out.println(hostingDTO);
        return "redirect:/hosting/house";
    }

    @GetMapping("/house")
    public String house() {
        return "hosting/house";
    }

    @GetMapping("/file")
    public String upload() {
        return "hosting/uploadTest";
    }

    @PostMapping("/file")
    public void upload(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String src = mtfRequest.getParameter("src");
        System.out.println("src value : " + src);
//        MultipartFile mf = mtfRequest.getFile("file");
        List<MultipartFile> mfs = mtfRequest.getFiles("file");

        //경로 지정
        String path = "C:\\upload/";

        for (MultipartFile mf : mfs) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            String safeFile = path + System.currentTimeMillis() + originFileName;
            System.out.println("path : " + path);
            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);
            System.out.println("safeFile : " + safeFile);

            File file = new File(safeFile);
            //경로에 디렉토리가 없으면 만들기
            if (!file.exists()) {
                boolean result = file.mkdirs();
                System.out.println("경로에 파일이 없음 : " + result);
            }

            try {
                mf.transferTo(file);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        String url = "/";
        String referer = request.getHeader("Referer");
        if (referer != null) {
            url = referer;
        }
        System.out.println(url);
        response.sendRedirect(url);
    }

}
