package hello.hellospring.service;

import hello.hellospring.domain.Competition;
import hello.hellospring.repository.CompetitionRepository;
import hello.hellospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
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
