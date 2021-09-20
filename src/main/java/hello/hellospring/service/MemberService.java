package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
        // 외부에서 넣어 주도록
    }

    /**
     * CREATE
     * 회원 가입
     */
    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getUser_id();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getUser_id())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                } );
    }

    /**
     * READ
     */

    /**
     *  특정 회원 id로 조회
     */
    public Optional<Member> findById(String user_id){
        return  memberRepository.findById(user_id);
    }

    /**
     *  특정 회원 name 으로 조회
     */
    public Optional<Member> findByName(String user_name){
        return  memberRepository.findById(user_name);
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
         return memberRepository.findAll();
    }

    /**
     * UPDATE
     * 회원 정보 수정
     */
    public Optional<Member> updateMember(String user_id, Member member) {
        return memberRepository.update(user_id, member);
    }

    /**
     * DELETE
     * 특정 회원 삭제
     */
    public String deleteMember(String user_id) {
        return memberRepository.delete(user_id);
    }


}
