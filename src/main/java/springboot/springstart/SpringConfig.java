package springboot.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.springstart.repository.JpaMemberRepository;
import springboot.springstart.repository.MemberRepository;
import springboot.springstart.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService((memberRepository()));
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
}
