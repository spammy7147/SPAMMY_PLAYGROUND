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
        System.out.println("/hosting/house => POST 요청");
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
    public String photo(MultipartHttpServletRequest multipartHttpServletRequest, Authentication authentication) {
        System.out.println("/hosting/photo => POST 요청");
       accommodationTempService.addPhoto(multipartHttpServletRequest, authentication);
        return "redirect:/";
    }
    @GetMapping("/accommodation/{accommodationId}")
    public String accommodation(@PathVariable Integer accommodationId) {
        System.out.println("/hosting/accommodation => GET 요청");
        System.out.println(accommodationId);
        return "hosting/accommodation";
    }
}
