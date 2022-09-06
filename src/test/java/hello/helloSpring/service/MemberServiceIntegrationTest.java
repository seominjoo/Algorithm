package hello.helloSpring.service;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {

        // given
        Member member = new Member();
        member.setName("hello1");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외외() {

        // given
        Member member1 = new Member();
        member1.setName("hello1");

        Member member2 = new Member();
        member2.setName("hello1");

        // when
        memberService.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("hello1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        memberService.join(member2);

        // when
        List<Member> result = memberService.findMembers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        // given
        Member member = new Member();
        member.setName("hello");
        memberService.join(member);
        // when
        Member result = memberService.findOne(member.getId()).get();
        // then
        assertThat(result.getName()).isEqualTo("hello");
    }
}
