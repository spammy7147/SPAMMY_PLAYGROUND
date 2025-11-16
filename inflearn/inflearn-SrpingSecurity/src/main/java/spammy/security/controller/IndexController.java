package spammy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    /**
     * SecurityProperties --초기화
     * SecurityFilterChainConfiguration --초기화설정
     * HttpSecurityConfiguration
     * AbstractConfiguredSecurityBuilder -- doBuild() 디버깅
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
