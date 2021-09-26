package hello.hellospring.domain;

import java.io.Serializable;

public class HoldemPubHasMemberId implements Serializable {
    private Long member;
    private Long holdemPub;

    public HoldemPubHasMemberId() {
    }

    public HoldemPubHasMemberId(Long member, Long holdemPub) {
        this.member = member;
        this.holdemPub = holdemPub;
    }
}
