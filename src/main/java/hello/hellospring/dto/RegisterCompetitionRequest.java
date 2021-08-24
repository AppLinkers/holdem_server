package hello.hellospring.dto;

import hello.hellospring.domain.Competition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class RegisterCompetitionRequest {

    private MultipartFile multipartFile;
    private Competition competition;
}
