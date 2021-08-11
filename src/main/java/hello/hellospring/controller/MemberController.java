package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/img")
    @ResponseBody
    public String imgTest() {
        return "imgTest";
    }

    //CREATE
    //회원 가입
    @PostMapping("/members/new")
    @ResponseBody //객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송.
    public Member create(@RequestBody Map<String, String> map) { //@RequestBody HTTP 요청 본문에 담긴 값들을 자바 객체로 변환하여 객체에 저장
        Member member = new Member();
        member.setUser_id(map.get("user_id"));
        member.setUser_name(map.get("user_name"));
        member.setUser_pass(map.get("user_pass"));

        memberService.join(member);

        return member;
    }


    //READ
    //로그인
    @PostMapping("/members/login")
    @ResponseBody
    public Optional<Member> login(@RequestBody Map<String, String> map) {
        Optional<Member> foundMember = memberService.findById(map.get("user_id"));
        if (foundMember.isPresent()) {
            if (foundMember.get().getUser_pass().equals(map.get("user_pass"))) {
                return foundMember;
            } else {
                Optional<Member> result = Optional.of(new Member());
                result.get().setUser_id("wrong_pass");
                return result;
            }
        } else{
            Optional<Member> result = Optional.of(new Member());
            result.get().setUser_id("no_member");
            return result;
        }
    }

    //전체 회원 조회
    @GetMapping("/members")
    @ResponseBody
    public List<Member> list() {
        List<Member> members = memberService.findMembers();
        return members;
    }

    //특정 회원 id로 조회
    @GetMapping("/members/findById")
    @ResponseBody
    public Optional<Member> findById(@RequestParam("user_id") String user_id) {
        Optional<Member> member = memberService.findById(user_id);
        return member;
    }

    //특정 회원 name 으로 조회
    @GetMapping("/members/findByName")
    @ResponseBody
    public Optional<Member> findByName(@RequestParam("user_name") String user_name) {
        Optional<Member> member = memberService.findByName(user_name);
        return member;
    }

    //UPDATE
    @Transactional // 해당 메소드를 하나의 트랙잭션으로 묶어주는 역할
    @PostMapping("/members/update")
    @ResponseBody
    public Optional<Member> updateMember(@RequestParam("user_id") String user_id, @RequestBody Map<String, String> map) {
        Member member = new Member();
        member.setUser_id(map.get("user_id"));
        member.setUser_name(map.get("user_name"));
        member.setUser_pass(map.get("user_pass"));

        memberService.updateMember(user_id, member);
        Optional<Member> result_member = memberService.findById(map.get("user_id"));

        return result_member;
    }

    //DELETE
    @Transactional
    @PostMapping("/members/delete")
    public String deleteMember(@RequestParam("user_id") String user_id) {
        memberService.deleteMember(user_id);
        return "redirect:/members";
    }

}
