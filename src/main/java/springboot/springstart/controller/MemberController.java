package springboot.springstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springboot.springstart.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // DI 의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
