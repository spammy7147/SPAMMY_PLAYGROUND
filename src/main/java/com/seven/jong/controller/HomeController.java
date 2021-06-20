package com.seven.jong.controller;

import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@GetMapping("/")
    public String home() {
	    System.out.println("main 진입");
        return "home";
    }
    @GetMapping("/test")
    public String test(@Nullable Authentication authentication) {
        System.out.println("/test 요청 들어옴");
        System.out.println(authentication);
        assert authentication != null;
        UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
        System.out.println("권한:" + authentication.getAuthorities());
        UserVO userVO = userSecurityVO.getUser();
        System.out.println("UserSecurityVO : " + userSecurityVO);
        System.out.println("userVO : " + userVO);
        return "home";
    }
}
