package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;


    @Test
    public void testMember() throws Exception {
        //given
        Member member = new Member("memberA");
        Member saveMember = memberJpaRepository.save(member);
        Member findMember = memberJpaRepository.find(saveMember.getId());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void basicCRUD() throws Exception {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        //리스트 조회 검증
        List<Member> all = memberJpaRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = memberJpaRepository.count();
        assertThat(count).isEqualTo(2);

        //삭제 검증
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);
        List<Member> deleteList = memberJpaRepository.findAll();
        assertThat(deleteList.size()).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThan() throws Exception {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member1", 20);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> resultList = memberJpaRepository.findByUsernameAndAgeGreaterThan("member1", 15);

        assertThat(resultList.get(0).getUsername()).isEqualTo("member1");
        assertThat(resultList.get(0).getAge()).isEqualTo(20);
        assertThat(resultList.size()).isEqualTo(1);
    }

    @Test
    public void namedQueryTest() throws Exception {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member1", 20);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> resultList = memberJpaRepository.findByUsername("member1");
        Member findMember = resultList.get(0);
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    public void paging() throws Exception {
       memberJpaRepository.save(new Member("member1", 10));
       memberJpaRepository.save(new Member("member2", 10));
       memberJpaRepository.save(new Member("member3", 10));
       memberJpaRepository.save(new Member("member4", 10));
       memberJpaRepository.save(new Member("member5", 10));
       memberJpaRepository.save(new Member("member6", 10));

       int age = 10;
       int offset = 0;
       int limit = 3;

        List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
        long totalCount = memberJpaRepository.totalCount(age);

        assertThat(members.size()).isEqualTo(3);
        assertThat(totalCount).isEqualTo(6);
    }

    @Test
    public void bulkUpdate() throws Exception {
        //given
        memberJpaRepository.save(new Member("member1", 10));
        memberJpaRepository.save(new Member("member2", 19));
        memberJpaRepository.save(new Member("member3", 20));
        memberJpaRepository.save(new Member("member4", 21));
        memberJpaRepository.save(new Member("member5", 40));
        memberJpaRepository.save(new Member("member6", 15));
        //when
        int result = memberJpaRepository.bulkAgePlus(20);

        //then
        assertThat(result).isEqualTo(3);
    }


}