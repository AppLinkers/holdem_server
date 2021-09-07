package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticket_name; // 티켓 대회 이름?
    private String ticket_place; // 티켓 사용 장소
    private int ticket_price; // 가격
    private int ticket_chatNum; // 해당 티켓 채팅 수
    private String ticket_poster; // 이미지

}
