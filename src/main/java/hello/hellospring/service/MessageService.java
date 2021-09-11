package hello.hellospring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.domain.Message;
import hello.hellospring.domain.Room;
import hello.hellospring.domain.Ticket;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MessageRepository;
import hello.hellospring.repository.RoomRepository;
import hello.hellospring.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final ObjectMapper objectMapper;
    private final SimpMessageSendingOperations messagingTemplate;

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    private final MessageRepository messageRepository;
    private final TicketRepository ticketRepository;

    public void send(Message message) {
        String senderName = message.getSenderName();

        if (message.getMessageType().equals("ENTER")) {

            // 입장 메시지 전달
            message.setMessage("[알림] " + senderName + " 님이 입장하였습니다.");
            messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoom().getId(), message);
            messageRepository.save(message);

        } else if (message.getMessageType().equals("TALK")) {

            // 채팅 처리
            messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoom().getId(), message);
            messageRepository.save(message);

        } else {

            // 채팅방 퇴장 메시지 전달
            message.setMessage("[알림]" + senderName + " 님이 퇴장하였습니다.");
            messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoom().getId(), message);

            // 채팅방 퇴장 처리
            Room room = message.getRoom();
            roomRepository.delete(room);

        }

    }

    public List<Message> findByRoomId(Long roomId) {
        return messageRepository.findByRoom(roomRepository.findById(roomId).get());
    }

}
