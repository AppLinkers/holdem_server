package hello.hellospring.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String messageType; // 생성 및 입장 / 퇴장 / 채팅 구분
    // Many : 1
    @ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="room_id")
    private Room room; // 채팅 방 식별자

    private Long senderId; // 채팅 전송자 식별자
    private String senderName; // 채팅 전송자 아이디
    private String message; // 채팅 본문

}
