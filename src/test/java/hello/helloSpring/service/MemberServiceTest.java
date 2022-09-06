package hello.helloSpring.service;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void 회원가입() {

        // given
        Member member = new Member();
        member.setName("hello1");

        // when
        Long saveId = service.join(member);

        // then
        Member findMember = service.findOne(saveId).get();
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
        service.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("hello1");
        service.join(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        service.join(member2);

        // when
        List<Member> result = service.findMembers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOne() {
        // given
        Member member = new Member();
        member.setName("hello");
        service.join(member);
        // when
        Member result = service.findOne(member.getId()).get();
        // then
        assertThat(result.getName()).isEqualTo("hello");
    }

}