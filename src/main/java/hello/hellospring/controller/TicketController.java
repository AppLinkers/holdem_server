package hello.hellospring.controller;

import hello.hellospring.domain.HoldemPub;
import hello.hellospring.domain.Ticket;
import hello.hellospring.dto.RegisterHoldemPubRequest;
import hello.hellospring.dto.RegisterTicketRequest;
import hello.hellospring.service.S3Uploader;
import hello.hellospring.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
        String ImgUrl = s3Uploader.upload(registerTicketRequest.getMultipartFile(), "ticket");
        Ticket ticket = registerTicketRequest.getTicket();
        ticket.setTicket_poster(ImgUrl);
        return ticketService.save(ticket);
    }

    @GetMapping("/list")
    public List<Ticket> list() {
        return ticketService.findAll();
    }
}
