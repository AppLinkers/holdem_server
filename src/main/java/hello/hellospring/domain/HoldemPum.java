package hello.hellospring.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class HoldemPum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pub_name; // 이름
    private String pub_open; // 운영 시간
    private String pub_place; // 위치
    private String pub_img; // 이미지

    @OneToOne(mappedBy = "holdem_pub")
    private Game game;
}
