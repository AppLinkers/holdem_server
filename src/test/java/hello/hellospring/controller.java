package hello.hellospring;

import hello.hellospring.config.SpringConfig;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

@SpringBootTest
public class controller {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    void findBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab - for 문 자동 생성
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }
    }
}
