package hello.hellospring.config;

import com.amazonaws.services.s3.AmazonS3Client;
import hello.hellospring.repository.*;
import hello.hellospring.service.CompetitionService;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
public class SpringConfig {

    private EntityManager em;
    private AmazonS3Client amazonS3Client;

    @Autowired
    public SpringConfig(EntityManager em, AmazonS3Client amazonS3Client) {
        this.em = em;
        this.amazonS3Client = amazonS3Client;
    }

    // Bean 직접 정의 및 MemberService 를 빈에 등록 및 memberRepository 의존성 주입
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public S3Uploader s3Uploader() {
        return new S3Uploader(amazonS3Client);
    }
}
