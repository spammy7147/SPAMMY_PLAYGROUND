package com.seven.jong.controller;

import com.seven.jong.DTO.hosting.ReservationAddRequestDTO;
import com.seven.jong.DTO.hosting.ReservationUpdateDTO;
import com.seven.jong.service.hosting.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    IReservationService reservationService;
    @Autowired
    public void setReservationService(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{reservationId}")
    public String reservation(@PathVariable Integer reservationId, Model model){
        System.out.println("/reservation/" + reservationId + " => GET 요청");
        model.addAttribute("reservation",reservationService.getReservationById(reservationId));

        return "hosting/reservation/reservation";
    }
    @GetMapping("/home")
    public String reservation(Model model, Authentication authentication){
        System.out.println("/reservation/home => GET 요청");
        model.addAttribute("reservation",reservationService.getAllReservationsByUser(authentication));

        return "hosting/reservation/reservationList";
    }

    @PostMapping("/add")
    public String reservationAdd(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication){
        System.out.println("/reservation/add => POST 요청 ");
        reservationService.addReservation(reservationAddRequestDTO,authentication);
        return "redirect:/hosting/accommodation/"+reservationAddRequestDTO.getAccommodationId();
    }

    @GetMapping("/update/{reservationId}")
    public String reservationUpdate(@PathVariable Integer reservationId, Authentication authentication, Model model) {
        System.out.println("/hosting/accommodation/delete"+reservationId +" => GET 요청");
        model.addAttribute("reservation",reservationService.getReservationById(reservationId));

        return "/hosting/reservation/updateReservation";
    }
    @PostMapping("/update/{reservationId}")
    public String reservationUpdate(ReservationUpdateDTO reservationUpdateDTO, Authentication authentication){
        reservationService.updateReservation(reservationUpdateDTO,authentication);
        return "redirect:/reservation/"+reservationUpdateDTO.getReservationId();
    }

    @GetMapping("/delete/{reservationId}")
    public String reservationDelete(@PathVariable Integer reservationId, Authentication authentication, RedirectAttributes redirectAttributes) {
        System.out.println("/hosting/accommodation/delete"+reservationId +" => GET 요청");
        if(reservationService.deleteReservation(reservationId,authentication)){
            redirectAttributes.addFlashAttribute("result","success");
        }
        return "redirect:/reservation/home";
    }
}
