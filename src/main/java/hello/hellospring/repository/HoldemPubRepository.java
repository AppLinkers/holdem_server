package hello.hellospring.repository;

import hello.hellospring.domain.HoldemPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldemPubRepository extends JpaRepository<HoldemPub, Long> {


}
