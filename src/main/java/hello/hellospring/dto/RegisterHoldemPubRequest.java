package hello.hellospring.dto;


import hello.hellospring.domain.HoldemPub;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class RegisterHoldemPubRequest {

    private MultipartFile multipartFile;
    private HoldemPub holdemPub;
}
