package inflearn.jpa.repository;

import inflearn.jpa.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;
    
    
    // 회원 저장
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 회원 찾기
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
