package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // member 회원 객체 저장
    //CREATE
    Member save(Member member);

    //READ
    Optional<Member> findById(String id); // optional - 값이 null일때 처리 하는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll();

    //UPDATE
    Optional<Member> update(String user_id, Member member);

    //DELETE
    String delete(String user_id);
}
