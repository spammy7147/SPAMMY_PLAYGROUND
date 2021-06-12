package com.seven.jong.controller;

import com.seven.jong.DTO.HostingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hosting")
public class HostingController {

    @GetMapping("/address")
    public String address() {

        return "hosting/address";
    }

    @PostMapping("/address")
    public String address(HostingDTO hostingDTO) {
        System.out.println(hostingDTO);
        return "hosting/type";
    }
}
