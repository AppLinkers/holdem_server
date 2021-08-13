package hello.hellospring.service;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.HoldemPum;
import hello.hellospring.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    // Save
    public Long save(Competition competition) {
        competitionRepository.save(competition);
        return competition.getId();
    }
}
