package springboot.springstart.repository;

import springboot.springstart.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member sava(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}