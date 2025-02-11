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
            List<Object[]> resultList = em.createQuery(query3)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

            for (Object[] objects : resultList) {
                System.out.println("objects = " + objects[0]);
                System.out.println("objects = " + objects[1]);
                System.out.println("objects = " + objects[2]);
                System.out.println("objects = " + objects[3]);
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
