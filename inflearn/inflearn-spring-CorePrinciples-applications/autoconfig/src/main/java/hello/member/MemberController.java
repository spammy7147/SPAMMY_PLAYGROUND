package hello.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/member")
    public Member getMember() {
        Member member = new Member("idA", "memberA");

        return member;
    }

}
