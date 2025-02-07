package inflearn.jpa;

import inflearn.jpa.domain.Member;
import inflearn.jpa.repository.MemberRepository;
import inflearn.jpa.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {

        // Given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(savedId));

    }


    @Test
    public void 중복_회원_예외() throws Exception {

        // Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");


        // when
        memberService.join(member1);

        // then
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        // 예외 메시지 검증
        Assertions.assertEquals("이미 존재한당께요 ~~ 빼애애액", exception.getMessage());
    }



}
