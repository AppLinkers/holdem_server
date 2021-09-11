package hello.hellospring.service;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.CompetitionHasMember;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.CompetitionRepository;
import hello.hellospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;

    // Save
    public Long save(Competition competition) {
        Competition result = competitionRepository.save(competition);
        return result.getId();
    }

    // findById
    public Competition findById(Long id) {
        return competitionRepository.findById(id).get();
    }

    // findAll
    public List<Competition> findCompetitions() {
        return competitionRepository.findAll();
    }

    public Competition newMember(Long competition_id, Long user_id) {
        CompetitionHasMember competitionHasMember = new CompetitionHasMember();

        Member member = memberRepository.findBy(user_id).get();
        Competition competition = competitionRepository.findById(competition_id).get();

        competitionHasMember.setCompetition(competition);
        competitionHasMember.setMember(member);

        member.addCompetitionHasMember(competitionHasMember);

        return competitionRepository.save(competition);
    }

    public List<Competition> findCompetitionsByUserId(String user_id) {
        return competitionRepository.findCompetitionsByUserId(user_id);
    }
}
