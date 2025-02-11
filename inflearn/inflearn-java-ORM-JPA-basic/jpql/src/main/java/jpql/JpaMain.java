package jpql;

import jakarta.persistence.*;
import jpql.domain.*;
import jpql.dto.MemberDTO;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team1 = new Team();
            team1.setName("팀A");
            em.persist(team1);
            Team team2 = new Team();
            team2.setName("팀B");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(team1);
            em.persist(member1);
            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(team1);
            em.persist(member2);
            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(team2);
            em.persist(member3);

            em.flush();
            em.clear();

            System.out.println("============================================");

            String query1 = "select m from Member as m inner join m.team t where t.name = :teamName";
            String query2 = "select m from Member m, Team t where m.username = t.name";
            String query3 = "select m.username, 'HELLO', TRUE, m.type from Member m where m.type = :userType";


//            List<Object[]> resultList = em.createQuery(query5)
////                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : resultList) {
//                for (Object object : objects) {
//                    System.out.println("object = " + object);
//                }
//            }

            String query4 = "select " +
                    "case when m.age <= 10 then '학생요금' " +
                    "when m.age >= 60 then '경로요금'" +
                    "else '일반요금' end " +
                    "from Member m";
            String query5 = "select coalesce(m.username, '이름 없는 회원') as username from Member m";
            String query6 = "select concat('a', 'b') from Member m";


//            List<String> resultList1 = em.createQuery(query5, String.class).getResultList();
//            for (String s : resultList1) {
//                System.out.println("s = " + s);
//            }

            //language=HQL
//            String query7 = "select locate('de','abcdegf') from Member m ";
//            List<Integer> resultList = em.createQuery(query7, Integer.class).getResultList();
//            for (Integer i : resultList) {
//                System.out.println("i = " + i);
//            }

//            String query8 = "select m from Member m join fetch m.team";
//            List<Member> members = em.createQuery(query8, Member.class).getResultList();
//            for (Member member : members) {
//                System.out.println("member.username = " + member.getUsername());
//                System.out.println("member.team.name = " + member.getTeam().getName());
//            }

//            String query9 = "select distinct t from Team t join fetch t.members";
//            List<Team> teams = em.createQuery(query9, Team.class).getResultList();
//            for (Team team : teams) {
//                System.out.println("team.getName = " + team.getName());
//                System.out.println("team.getMembers = " + team.getMembers());
//                for (Member member : team.getMembers()) {
//                    System.out.println("team.getMembers.username = " + member.getUsername());
//                }
//            }

//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }

            int resultCnt = em.createQuery("update Member m set m.age = :age")
                    .setParameter("age", 20)
                    .executeUpdate();

            System.out.println("resultCnt = " + resultCnt);

            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }


}
