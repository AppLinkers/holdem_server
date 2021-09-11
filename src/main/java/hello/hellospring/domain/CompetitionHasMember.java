package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "competition_has_member")
@Entity
@Getter
@Setter
public class CompetitionHasMember implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
}