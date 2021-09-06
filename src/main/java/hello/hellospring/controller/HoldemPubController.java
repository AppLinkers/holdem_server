package hello.hellospring.controller;

import hello.hellospring.domain.HoldemPub;
import hello.hellospring.dto.RegisterHoldemPubRequest;
import hello.hellospring.service.HoldemPubService;
import hello.hellospring.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HoldemPubController {

    private final HoldemPubService holdemPubService;
    private final S3Uploader s3Uploader;

    @PostMapping("/holdem_pub/save")
    public HoldemPub save(@ModelAttribute RegisterHoldemPubRequest registerHoldemPubRequest) throws IOException {
        String ImgUrl = s3Uploader.upload(registerHoldemPubRequest.getMultipartFile(), "holdemPub");
        HoldemPub holdemPub = registerHoldemPubRequest.getHoldemPub();
        holdemPub.setPub_img(ImgUrl);
        return holdemPubService.save(holdemPub);
    }

    @GetMapping("/holdem_pub/list")
    public List<HoldemPub> list() {
        return holdemPubService.findAll();
    }
}
