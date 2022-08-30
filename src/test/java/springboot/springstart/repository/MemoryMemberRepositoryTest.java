package springboot.springstart.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springboot.springstart.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; // static import로 없앨수 있음.

public class MemoryMemberRepositoryTest {

    /**
     *
     * Test code 주의점
     * 모든 Test는 순서와 상관없이 동작이 따로 이루어짐.
     * 그러므로 테스트 종료시 데이터를 깔끔하게 지워주는 코드가 필요함.
     */

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // method가 끝날때마다 어떠한 동작을 수행함.
    public void afterEach() {
        repository.clearStore(); // test 가 실행되고 끝날때마다 한번씩 저장소를 지움.
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.sava(member);
        Member result = repository.findById(member.getId()).get();

        // System.out.println(result.equals(member));
        // Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.sava(member1);

        // shift + F6 은 rename 기능을 가짐.
        Member member2 = new Member();
        member2.setName("spring2");
        repository.sava(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.sava(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.sava(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
    
}
