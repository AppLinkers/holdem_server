package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // 생성자로 SPRING 빈에 memberRepository 객체를 올려준다.
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Bean 직접 정의 및 MemberService 를 빈에 등록 및 memberRepository 의존성 주입
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
