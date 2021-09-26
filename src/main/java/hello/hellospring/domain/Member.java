package hello.hellospring.domain;

import com.amazonaws.services.ec2.model.SpotInstanceType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB 가 알아서 생성
    private long id;
    private String user_id;
    private String user_pass;
    private String user_name;
    private String user_phone;
    private String user_loc;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HoldemPubHasMember> holdemPubHasMemberList = new ArrayList<>();

    // 사용자를 대회에 추가
    public void addHoldemPubHasMember(HoldemPubHasMember holdemPubHasMember) {
        this.holdemPubHasMemberList.add(holdemPubHasMember);
    }


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RoomHasMember> roomHasMemberList = new ArrayList<>();

    // 사용자를 채팅방에 추가
    public void addRoomHasMember(RoomHasMember roomHasMember) {
        this.roomHasMemberList.add(roomHasMember);
    }


}
