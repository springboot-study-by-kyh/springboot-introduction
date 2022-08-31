package springboot.springstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.springstart.domain.Member;
import springboot.springstart.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// service는 비즈니스 롤에 맞게끔 이름을 작성해주고, repository는 단순 기계식 작동에 맞게 명칭작성을 해주면됨.
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    
    @Autowired 
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return long
     */
    public Long join(Member member){

        long start = System.currentTimeMillis();

        try {
            // 회원가입시 중복회원 불가.
            validateDuplicateMember(member);

            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long result = finish - start;
            System.out.println("result : " + result);
        }


    }

    // 검증로직을 method로 따로 빼서 사용
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> { // return 값이 optional 이기에 사용가능.
            throw new IllegalStateException("이미 존재하는 회원.");
        });
    }

    /**
     * 전체회원 조회
     * @return member
     */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }




}
