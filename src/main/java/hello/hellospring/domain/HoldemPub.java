package hello.hellospring.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class HoldemPub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holdem_pub_id")
    private Long id;
    private String pub_name; // 이름
    private String pub_info; // 한마디 설명
    private String pub_open; // 운영 시간
    private String pub_place; // 위치
    private String pub_img; // 이미지

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
}
