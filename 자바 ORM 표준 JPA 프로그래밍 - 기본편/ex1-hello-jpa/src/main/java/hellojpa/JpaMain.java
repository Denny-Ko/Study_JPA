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

        //insert
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("helloB");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        //select
        /*try {
            Member findMember = em.find(Member.class, 1L);

            //delete
//            em.remove(findMember);

            //update : 저장할 필요도 없다. like Collection
            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //JPQL
        /*try {

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1).setMaxResults(10)
                            .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        emf.close();

    }
}
