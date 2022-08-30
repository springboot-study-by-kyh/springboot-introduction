package springboot.springstart.repository;

import org.springframework.stereotype.Repository;
import springboot.springstart.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member sava(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이어도 반환가능.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // store 에서 name을 하나라도 찾으면 optional 반환하고 없을 경우 null 이 반환.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store의 값들을 전부 반환해줌.
    }

    public void clearStore(){
        store.clear(); // store를 전부 비움
    }

}
