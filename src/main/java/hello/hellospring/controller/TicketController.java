package hello.hellospring.controller;

import hello.hellospring.domain.Ticket;
import hello.hellospring.dto.RegisterTicketRequest;
import hello.hellospring.service.S3Uploader;
import hello.hellospring.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final S3Uploader s3Uploader;
    private final TicketService ticketService;

    @PostMapping("/save")
    public Ticket save(@ModelAttribute RegisterTicketRequest registerTicketRequest) throws IOException {
        Ticket ticket = registerTicketRequest.getTicket();
        String ImgUrl = s3Uploader.upload(registerTicketRequest.getMultipartFile(), "ticket");
        ticket.setTicket_poster(ImgUrl);
        return ticketService.save(ticket);
    }

    @GetMapping("/list")
    public List<Ticket> list() {
        return ticketService.findAll();
    }

    @GetMapping("/remove/{ticket_id}")
    public void remove(@PathVariable Long ticket_id) {
        ticketService.remove(ticket_id);
    }

    @GetMapping("/list/{user_id}")
    public List<Ticket> list(@PathVariable Long user_id){
        return ticketService.findAllByMemberId(user_id);
    }
}
