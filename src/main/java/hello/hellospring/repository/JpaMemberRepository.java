package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    //CREATE
    @Override
    public Member save(Member member) {
        em.persist(member); // jpa가 자동 처리
        return member;
    }

    //READ
    @Override
    public Optional<Member> findById(String user_id) {
        List<Member> result = em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                .setParameter("user_id", user_id)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String user_name) {
        List<Member> result = em.createQuery("select m from Member m where m.user_name = :user_name", Member.class)
                .setParameter("user_name", user_name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); //JPQL 쿼리 언어
    }

    //UPDATE
    @Override
    @Transactional
    @Modifying(clearAutomatically = true)
    public Optional<Member> update(String user_id, Member member) {
        String get_user_id = member.getUser_id();
        String get_user_name = member.getUser_name();
        String get_user_pass = member.getUser_pass();
        em.createQuery("update Member m set m.user_id = :get_user_id,m.user_name = :get_user_name, m.user_pass = :get_user_pass where m.user_id = :user_id")
                .setParameter("user_id", user_id)
                .setParameter("get_user_id", get_user_id)
                .setParameter("get_user_name", get_user_name)
                .setParameter("get_user_pass", get_user_pass)
                .executeUpdate();
        Optional<Member> selected_member = findById(user_id);

        return selected_member;
    }

    //DELETE
    @Override
    public String delete(String user_id) {
        em.createQuery("delete from Member m where m.user_id = :user_id")
                .setParameter("user_id", user_id)
                .executeUpdate();
        return "삭제 성공";
    }
}
