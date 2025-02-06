package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

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
            NewMember newMember = new NewMember();
            newMember.setUsername("hello");
            newMember.setHomeAddress(new Address("city", "street", "zipCode"));
            newMember.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));

            newMember.getFavoriteFoods().add("치킨");
            newMember.getFavoriteFoods().add("족발");
            newMember.getFavoriteFoods().add("피자");

            newMember.getAddressHistory().add(new Address("city1", "street1", "zipCode1"));
            newMember.getAddressHistory().add(new Address("city2", "street2", "zipCode2"));

            em.persist(newMember);

//            Child child1 = new Child();
//            child1.setName("C1");
//            Child child2 = new Child();
//            child2.setName("C2");
//            Parent parent = new Parent();
//            parent.setName("P1");
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);

//            em.persist(child1);
//            em.persist(child2);


//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//            member.setUsername("user1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("==");
//            System.out.println(findMember.getTeam().getClass());
//            findMember.getTeam().getName();

//            Member referenceMember = em.getReference(Member.class, member.getId());
//
//            System.out.println("isLoadedBefore = " + emf.getPersistenceUnitUtil().isLoaded(referenceMember));
//
//            System.out.println("referenceMember = " + referenceMember.getClass());
//            System.out.println("referenceMember.getId = " + referenceMember.getId());
//            System.out.println("referenceMember.getUsername = " + referenceMember.getUsername());
//
//            ;
//            System.out.println("isLoadedAfter = " + emf.getPersistenceUnitUtil().isLoaded(referenceMember));
//            Hibernate.initialize(referenceMember); //강제 초기화

//            printMemberAndTeam(findMember);


            tx.commit();
        }catch (Exception e) {
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
