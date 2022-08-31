package springboot.springstart.repository;

import springboot.springstart.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository
{

    private final EntityManager em; // jpa는 entitymanager로 모든 동작을 함.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member sava(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);// 조회할 식별자랑 PK 넣어주면 Select 문 생성.
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name ", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member n", Member.class)
                .getResultList();

    }

    private static List<Member> getResult(List<Member> result) {
        return result;
    }
}
