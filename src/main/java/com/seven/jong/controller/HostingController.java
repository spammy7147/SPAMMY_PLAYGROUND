package com.seven.jong.controller;

import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.service.hosting.IAccommodationTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/hosting")
public class HostingController {

    IAccommodationTempService accommodationTempService;
    @Autowired
    public void setAccommodationTempService(IAccommodationTempService accommodationTempService) {
        this.accommodationTempService = accommodationTempService;
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("/hosting/home => GET 요청");
        return "/hosting/hostHome";
    }

    @GetMapping("/address")
    public String address(Authentication authentication, Model model) {
        System.out.println("/hosting/address => GET 요청");
        AccommodationTempVO accommodationTempVO = accommodationTempService.findByUserId(authentication);
        if(accommodationTempVO != null){
            model.addAttribute("accommodationTempVO", accommodationTempVO);
        }
        return "/hosting/address";
    }

    @PostMapping("/address")
    public String address(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication) {
        System.out.println("/hosting/address => POST 요청");
        System.out.println(accommodationAddressRequestDTO);
        accommodationTempService.addAddress(accommodationAddressRequestDTO, authentication);
        return "redirect:/hosting/house";
    }

    @GetMapping("/house")
    public String house(Authentication authentication, Model model) {
        System.out.println("/hosting/house => GET 요청");
        AccommodationTempVO accommodationTempVO = accommodationTempService.findByUserId(authentication);
        if(accommodationTempVO != null){
            model.addAttribute("accommodationTempVO", accommodationTempVO);
        }
        return "hosting/house";
    }

    @PostMapping("/house")
    public String house(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Authentication authentication){
        System.out.println(accommodationHouseRequestDTO);
        accommodationTempService.addHouse(accommodationHouseRequestDTO, authentication);
        return "redirect:/hosting/photo";
    }
    @GetMapping("/photo")
    public String photo() {
        System.out.println("/hosting/photo => GET 요청");
        return "hosting/photo";
    }

    @PostMapping("/photo")
    public String photo(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/hosting/photo => POST 요청");
        List<MultipartFile> mfs = mtfRequest.getFiles("file");
       for(MultipartFile mf : mfs) {
           System.out.println(mf.getOriginalFilename());
       }
        return "hosting/photo";
    }
    @GetMapping("/accommodation/{accommodationId}")
    public String accommodation(@PathVariable Integer accommodationId) {
        System.out.println("/hosting/accommodation => GET 요청");
        System.out.println(accommodationId);
        return "hosting/accommodation";
    }

//    @GetMapping("/file")
//    public String upload() {
//        return "hosting/uploadTest";
//    }

//    @PostMapping("/file")
//    public void upload(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        String src = mtfRequest.getParameter("src");
//        System.out.println("src value : " + src);
////        MultipartFile mf = mtfRequest.getFile("file");
//        List<MultipartFile> mfs = mtfRequest.getFiles("file");
//
//        //경로 지정
//        String path = "C:\\upload/";
//
//        for (MultipartFile mf : mfs) {
//            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
//            long fileSize = mf.getSize(); // 파일 사이즈
//
//            String safeFile = path + System.currentTimeMillis() + originFileName;
//            System.out.println("path : " + path);
//            System.out.println("originFileName : " + originFileName);
//            System.out.println("fileSize : " + fileSize);
//            System.out.println("safeFile : " + safeFile);
//
//            File file = new File(safeFile);
//            //경로에 디렉토리가 없으면 만들기
//            if (!file.exists()) {
//                boolean result = file.mkdirs();
//                System.out.println("경로에 파일이 없음 : " + result);
//            }
//
//            try {
//                mf.transferTo(file);
//            } catch (IllegalStateException | IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//
//        String url = "/";
//        String referer = request.getHeader("Referer");
//        if (referer != null) {
//            url = referer;
//        }
//        System.out.println(url);
//        response.sendRedirect(url);
//    }

}
