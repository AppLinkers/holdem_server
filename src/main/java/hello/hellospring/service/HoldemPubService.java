package hello.hellospring.service;

import hello.hellospring.domain.HoldemPub;
import hello.hellospring.repository.HoldemPubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoldemPubService {

    private final HoldemPubRepository holdemPubRepository;

    public HoldemPub save(HoldemPub holdemPub) {
        return holdemPubRepository.save(holdemPub);
    }

    public List<HoldemPub> findAll() {
        return holdemPubRepository.findAll();
    }
}
