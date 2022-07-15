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

        //persist/detach/remove
        /*try {
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            System.out.println("=== BEFORE ===");
            //영속
            em.persist(member);
            //영속 제거
//            em.detach(member);
//            em.remove(member);
            System.out.println("=== AFTER ===");
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //persist : 1차 캐쉬
        /*try {
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            em.persist(member);

            System.out.println("=== BEFORE ===");
            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            System.out.println("=== AFTER ===");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //find : DB -> persist
        /*try {
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //동일성
        /*try {
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println(" = " + (findMember1 == findMember2));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //flush는 언제?
        /*try {
            Member findMember1 = new Member(150L, "A");
            Member findMember2 = new Member(160L, "B");

            em.persist(findMember1);
            em.persist(findMember2);

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //변경 감지(Dirty Checking) : Entity & SnapShot
        /*try {
            Member member = em.find(Member.class, 160L);
            member.setName("ZZZ");

            //불필요! 이미 persist상태
            *//*em.persist(member);*//*

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //flush/commit/JPQL
        /*try {
            Member member = new Member(200L, "member200");

            em.persist(member);

            em.flush();

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        /*try {
            Member member = new Member(200L, "member200");

            em.persist(member);

            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        //detach/clear/close
        /*try {
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member);
//            em.clear();
//            em.close();

            Member member2 = em.find(Member.class, 150L);

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }*/

        emf.close();

    }
}
