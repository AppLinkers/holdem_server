package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "holdemPub_has_member")
@Entity
@IdClass(HoldemPubHasMemberId.class)
@Getter
@Setter
public class HoldemPubHasMember implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "pub_id")
    private HoldemPub holdemPub;

}