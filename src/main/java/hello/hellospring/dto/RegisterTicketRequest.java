package hello.hellospring.dto;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.Ticket;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class RegisterTicketRequest {

    private MultipartFile multipartFile;
    private Ticket ticket;
}
