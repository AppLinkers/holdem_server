package hello.hellospring.repository;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.HoldemPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldemPubRepository extends JpaRepository<HoldemPub, Long> {
    @Query("select h from HoldemPub h where h.id = any(select hhm.holdemPub.id from HoldemPubHasMember hhm where hhm.member.id = (select m.id from Member m where m.user_id = :user_id))")
    List<HoldemPub> findHoldemPubByUserId(@Param("user_id") String user_id);

}
