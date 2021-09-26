package hello.hellospring.controller;

import hello.hellospring.domain.Competition;
import hello.hellospring.domain.HoldemPub;
import hello.hellospring.dto.RegisterHoldemPubRequest;
import hello.hellospring.service.HoldemPubService;
import hello.hellospring.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/holdem_pub")
@RequiredArgsConstructor
public class HoldemPubController {

    private final HoldemPubService holdemPubService;
    private final S3Uploader s3Uploader;

    @PostMapping("/save")
    public HoldemPub save(@ModelAttribute RegisterHoldemPubRequest registerHoldemPubRequest) throws IOException {
        String ImgUrl = s3Uploader.upload(registerHoldemPubRequest.getMultipartFile(), "holdemPub");
        HoldemPub holdemPub = registerHoldemPubRequest.getHoldemPub();
        holdemPub.setPub_img(ImgUrl);
        return holdemPubService.save(holdemPub);
    }

    @GetMapping("/list")
    public List<HoldemPub> list() {
        return holdemPubService.findAll();
    }

    // 즐겨찾는 모임 추가
    @PostMapping("/new_member")
    public HoldemPub newMember(@RequestParam Long holdemPub_id, @RequestParam String member_id) {
        return  holdemPubService.newMember(holdemPub_id, member_id);
    }

    // 즐겨찾는 모임에서 삭제
    @PostMapping("/delete_member")
    public HoldemPub deleteMember(@RequestParam Long holdemPub_id, @RequestParam String member_id) {
        return holdemPubService.deleteMember(holdemPub_id, member_id);
    }

    // 사용자 아이디로 즐겨찾는 모임조회
    @GetMapping("/list/{member_id}")
    public List<HoldemPub> findHoldemPubByUserId(@PathVariable String member_id) {
        return holdemPubService.findHoldemPubByUserId(member_id);
    }
}
