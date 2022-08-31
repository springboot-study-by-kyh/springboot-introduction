package springboot.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.springstart.repository.JpaMemberRepository;
import springboot.springstart.repository.MemberRepository;
import springboot.springstart.service.MemberService;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService((memberRepository));
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//    }
}
