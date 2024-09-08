package com.seven.jong.controller;

import com.seven.jong.DTO.common.PageCreator;
import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.service.hosting.IAccommodationService;
import com.seven.jong.service.hosting.IAccommodationTempService;
import com.seven.jong.service.hosting.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/hosting")
public class HostingController {

    IAccommodationTempService accommodationTempService;
    IAccommodationService accommodationService;
    IReservationService reservationService;
    @Autowired
    public void setAccommodationTempService(IAccommodationTempService accommodationTempService) {
        this.accommodationTempService = accommodationTempService;
    }
    @Autowired
    public void setAccommodationService(IAccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @Autowired
    public void setReservationService(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/home")
    public String home(Authentication authentication, Model model, PageDTO pageDTO) {
        System.out.println("/hosting/home => GET 요청");
        List<AccommodationVO> accommodationVOList = accommodationService.getAllByUserId(authentication,pageDTO);
        PageCreator pc = new PageCreator();
        pc.setPaging(pageDTO);
        pc.setArticleTotalCount(accommodationService.getNumberAccommodationByUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId()));
        model.addAttribute("pc",pc);
        model.addAttribute("accommodations", accommodationVOList);

        return "hosting/accommodation/accommodationList";
    }

    @GetMapping("/address")
    public String address(Authentication authentication, Model model) {
        System.out.println("/hosting/address => GET 요청");
        AccommodationTempVO accommodationTempVO = accommodationTempService.findByUserId(authentication);
        if(accommodationTempVO != null){
            model.addAttribute("accommodationTempVO", accommodationTempVO);
        }
        return "hosting/accommodation/address";
    }

    @PostMapping("/address")
    public String address(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication) {
        System.out.println("/hosting/address => POST 요청");
        System.out.println(accommodationAddressRequestDTO);
        accommodationTempService.addAddress(accommodationAddressRequestDTO, authentication);
        return "hosting/accommodation/house";
    }

    @GetMapping("/house")
    public String house(Authentication authentication, Model model) {
        System.out.println("/hosting/house => GET 요청");
        AccommodationTempVO accommodationTempVO = accommodationTempService.findByUserId(authentication);
        if(accommodationTempVO != null){
            model.addAttribute("accommodationTempVO", accommodationTempVO);
        }
        return "hosting/accommodation/house";
    }

    @PostMapping("/house")
    public String house(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Authentication authentication){
        System.out.println("/hosting/house => POST 요청");
        System.out.println(accommodationHouseRequestDTO);
        accommodationTempService.addHouse(accommodationHouseRequestDTO, authentication);
        return "hosting/accommodation/photo";
    }
    @GetMapping("/photo")
    public String photo() {
        System.out.println("/hosting/photo => GET 요청");
        return "hosting/accommodation/photo";
    }

    @PostMapping("/photo")
    public String photo(MultipartHttpServletRequest multipartHttpServletRequest, Authentication authentication) {
        System.out.println("/hosting/photo => POST 요청");
       accommodationTempService.addPhoto(multipartHttpServletRequest, authentication);
        return "redirect:/";
    }
    @GetMapping("/accommodation/{accommodationId}")
    public String accommodation(@PathVariable Integer accommodationId, Model model) {
        System.out.println("/hosting/accommodation => GET 요청");
        model.addAttribute("accommodation",accommodationService.getOneById(accommodationId));
        return "hosting/accommodation/accommodation";
    }

    @GetMapping("/file/{accommodationId}")
    public void src(@PathVariable Integer accommodationId, @Nullable @RequestParam String url, HttpServletResponse response){
        accommodationService.getPhoto(accommodationId,url,response);
    }

    @GetMapping("/accommodation/delete/{accommodationId}")
    public String accommodationDelete(@PathVariable Integer accommodationId, Authentication authentication, RedirectAttributes redirectAttributes) {
        System.out.println("/hosting/accommodation/delete"+accommodationId +" => GET 요청");
        if(accommodationService.deleteAccommodation(accommodationId,authentication)){
            redirectAttributes.addFlashAttribute("result","success");
        }
        return "redirect:/hosting/home";
    }

    @GetMapping("/accommodation/update/{accommodationId}")
    public String accommodationUpdate(@PathVariable Integer accommodationId, Model model) {
        System.out.println("/hosting/accommodation/update/"+accommodationId +" => GET 요청");
        model.addAttribute("accommodation",accommodationService.getOneById(accommodationId));
        return "hosting/accommodation/updateAccommodation";
    }

    @PostMapping("/accommodation/updateAddress/{accommodationId}")
    @ResponseBody
    public void accommodationUpdateAddress(@PathVariable Integer accommodationId, @RequestBody AccommodationAddressRequestDTO accommodationAddressRequestDTO) {
        System.out.println("/hosting/accommodation/updateAddress/"+accommodationId +" => POST 요청");
        System.out.println(accommodationAddressRequestDTO);
        accommodationService.updateAddress(accommodationAddressRequestDTO, accommodationId);

    }
    @PostMapping("/accommodation/updateHouse/{accommodationId}")
    @ResponseBody
    public void accommodationUpdateHouse(@PathVariable Integer accommodationId, @RequestBody AccommodationHouseRequestDTO accommodationHouseRequestDTO) {
        System.out.println("/hosting/accommodation/updateAddress/"+accommodationId +" => POST 요청");
        System.out.println(accommodationHouseRequestDTO);
        accommodationService.updateHouse(accommodationHouseRequestDTO, accommodationId);
    }

    @GetMapping("/search")
    public String search(SearchDTO searchDTO, Model model){
        searchDTO.setCountPerPage(8);
        System.out.println("/hosting/search => GET 요청");
        System.out.println(searchDTO);
        List<AccommodationVO> accommodationVOList = accommodationService.searchAccommodation(searchDTO);
        PageCreator pc = new PageCreator();
        pc.setPaging(searchDTO);
        pc.setArticleTotalCount(accommodationService.countSearch(searchDTO));
        model.addAttribute("pc",pc);
        model.addAttribute("accommodations",accommodationVOList);
        System.out.println(accommodationService.searchAccommodation(searchDTO));
        return "hosting/search/search";
    }



}
