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
            for (int i = 1; i < 2; i++) {
                Team team = new Team();
                team.setName("team" + i);
                em.persist(team);

                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                member.setType(MemberType.ADMIN);
                member.changeTeam(team);
                em.persist(member);
            }

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


            List<String> resultList1 = em.createQuery(query5, String.class).getResultList();
            for (String s : resultList1) {
                System.out.println("s = " + s);
            }

            //language=HQL
            String query7 = "select locate('de','abcdegf') from Member m";
            List<Integer> resultList = em.createQuery(query7, Integer.class).getResultList();

            for (Integer i : resultList) {
                System.out.println("i = " + i);
            }


            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team);
    }
}
