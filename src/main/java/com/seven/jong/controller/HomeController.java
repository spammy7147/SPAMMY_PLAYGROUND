package com.seven.jong.controller;

import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@GetMapping("/")
    public String home() {
	    System.out.println("/ => GET 요청");
        return "home";
    }
}
