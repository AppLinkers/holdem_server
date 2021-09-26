package hello.hellospring.service;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.HoldemPub;
import hello.hellospring.domain.HoldemPubHasMember;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.HoldemPubHasMemberRepository;
import hello.hellospring.repository.HoldemPubRepository;
import hello.hellospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoldemPubService {

    private final HoldemPubRepository holdemPubRepository;
    private final MemberRepository memberRepository;
    private final HoldemPubHasMemberRepository holdemPubHasMemberRepository;

    public HoldemPub save(HoldemPub holdemPub) {
        return holdemPubRepository.save(holdemPub);
    }

    public List<HoldemPub> findAll() {
        return holdemPubRepository.findAll();
    }

    public HoldemPub newMember(Long holdemPub_id, String user_id) {
        HoldemPubHasMember holdemPubHasMember = new HoldemPubHasMember();

        Member member = memberRepository.findById(user_id).get();
        HoldemPub holdemPub = holdemPubRepository.findById(holdemPub_id).get();

        holdemPubHasMember.setHoldemPub(holdemPub);
        holdemPubHasMember.setMember(member);

        member.addHoldemPubHasMember(holdemPubHasMember);

        return holdemPubRepository.save(holdemPub);
    }

    @Transactional
    public HoldemPub deleteMember(Long holdemPub_id, String user_id) {
        HoldemPubHasMember holdemPubHasMember = new HoldemPubHasMember();

        Member member = memberRepository.findById(user_id).get();
        HoldemPub holdemPub = holdemPubRepository.findById(holdemPub_id).get();

        holdemPubHasMember.setHoldemPub(holdemPub);
        holdemPubHasMember.setMember(member);

        holdemPubHasMemberRepository.delete(holdemPubHasMember);

        return holdemPubRepository.save(holdemPub);
    }

    public List<HoldemPub> findHoldemPubByUserId(String user_id) {
        return holdemPubRepository.findHoldemPubByUserId(user_id);
    }
}
