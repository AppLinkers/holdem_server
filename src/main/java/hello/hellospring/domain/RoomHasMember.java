package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "room_has_member")
@Entity
@Getter
@Setter
public class RoomHasMember implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
