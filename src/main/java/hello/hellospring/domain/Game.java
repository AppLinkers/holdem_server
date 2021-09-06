package hello.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter @Getter
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "game")
    private HoldemPub holdemPub;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean game1;
    @Convert(converter = BooleanToYNConverter.class)
    private boolean game2;
    @Convert(converter = BooleanToYNConverter.class)
    private boolean game3;

}
