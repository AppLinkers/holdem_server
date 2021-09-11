package hello.hellospring.controller;

import hello.hellospring.domain.Message;
import hello.hellospring.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/message/{room_id}")
    @ResponseBody
    public List<Message> messageList(@PathVariable Long room_id) {
        return messageService.findByRoomId(room_id);
    }

    @MessageMapping("/chat/message")
    public void message(Message message) {
        messageService.send(message);
    }
}
