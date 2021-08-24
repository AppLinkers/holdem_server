package hello.hellospring.controller;

import hello.hellospring.domain.Competition;
import hello.hellospring.dto.RegisterCompetitionRequest;
import hello.hellospring.service.CompetitionService;
import hello.hellospring.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;
    private final S3Uploader s3Uploader;


    @PostMapping("/competition/save")
    @ResponseBody
    public Competition save(@ModelAttribute RegisterCompetitionRequest registerCompetitionRequest) throws IOException {
        String ImgUrl = s3Uploader.upload(registerCompetitionRequest.getMultipartFile(), "competition");
        System.out.println(ImgUrl);
        Competition competition = registerCompetitionRequest.getCompetition();
        competition.setCmp_img(ImgUrl);
        Long resultId = competitionService.save(competition);
        return competitionService.findById(resultId);
    }
}
