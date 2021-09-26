package hello.hellospring.repository;

import hello.hellospring.domain.HoldemPubHasMember;
import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldemPubHasMemberRepository extends JpaRepository<HoldemPubHasMember, Member> {
}