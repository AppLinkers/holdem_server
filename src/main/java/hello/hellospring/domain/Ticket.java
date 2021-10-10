package hello.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticket_name; // 티켓 대회 이름?
    private String ticket_place; // 티켓 사용 장소
    private int ticket_price; // 가격
    private int ticket_chatNum; // 해당 티켓 채팅 수
    private String ticket_poster; // 이미지

    @JsonIgnore
    @OneToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Member member;

    @JsonIgnore
    @OneToOne(targetEntity = Room.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "room_id")
    private Room room;
}
