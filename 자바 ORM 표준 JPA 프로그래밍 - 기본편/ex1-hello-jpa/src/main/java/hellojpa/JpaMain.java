package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Locker locker = new Locker();
            locker.setName("LockerA");

            Member member = new Member();
            member.setUsername("UserA");

            member.setLocker(locker);
            locker.setMember(member);

            em.persist(locker);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, 2L);

            System.out.println("====================");
            System.out.println("findMember = " + findMember.getUsername());
            System.out.println("====================");

            Locker findLocker = findMember.getLocker();

            System.out.println("====================");
            System.out.println("findLocker = " + findLocker.getName());
            System.out.println("====================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();

    }
}
