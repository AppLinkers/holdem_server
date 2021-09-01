package hello.hellospring.service;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.HoldemPum;
import hello.hellospring.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

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


}
