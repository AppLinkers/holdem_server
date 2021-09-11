package hello.hellospring.repository;

import hello.hellospring.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    @Query("select c from Competition c where c.id = any(select chm.competition.id from CompetitionHasMember chm where chm.member.id = (select m.id from Member m where m.user_id = :user_id))")
    List<Competition> findCompetitionsByUserId(@Param("user_id") String user_id);
}
