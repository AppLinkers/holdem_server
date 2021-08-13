package hello.hellospring.controller;

import hello.hellospring.domain.Competition;
import hello.hellospring.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CompetitionController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    @ResponseBody
    public Competition save(@RequestBody Map<String, String> map) {
        Competition competition = new Competition();
        competition.setCmp_name(map.get("cpm_name"));
        competition.setCmp_img(map.get("cmp_img"));
        competition.setCmp_place(map.get("cmp_place"));
        competition.setCmp_buyIn(Integer.parseInt(map.get("cmp_buyIn")));
        competition.setCmp_start(map.get("cmp_start"));
        competition.setCmp_end(map.get("cmp_end"));
        competitionService.save(competition);
        return competition;
    }
}
