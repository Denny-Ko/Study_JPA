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

        /*try{
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeamId(team.getId());

            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());

            Long findTeamId = findMember.getTeamId();
            Team findTeam = em.find(Team.class, findTeamId);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/

        //단방향 매핑
        /*try{
            //저장
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //조회
            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();

            System.out.println("findTeam = " + findTeam.getName());

            //수정
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/


        /*try{
            //저장
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //조회
            Member findMember = em.find(Member.class, member.getId());

            List<Member> members = findMember.getTeam().getMembers();

            for (Member m :
                    members) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/


        /*try{
            //저장
            //잘못된 예시
            *//*Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("TeamA");
            team.getMembers().add(member);

            em.persist(team);

            em.flush();
            em.clear();*//*

            //옳은 예시
            *//*Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();*//*

            //그런데 flush clear 안하면 문제 발생. 따라서 양방향 매핑시 양쪽에 다 값을 세팅해주는 것이 맞다.
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);

            em.persist(member);

            team.getMembers().add(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> findTeamMembers = findTeam.getMembers();

            System.out.println("===================");
            for (Member m :
                    findTeamMembers) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/

        //연관관계 편의 메서드 : Member.setTeam()
        /*try{
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);

            em.persist(member);

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> findTeamMembers = findTeam.getMembers();

            System.out.println("===================");
            for (Member m :
                    findTeamMembers) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/

        //연관관계 편의 메서드 : Team.addMember()
        /*try{
            Team team = new Team();
            team.setName("TeamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> findTeamMembers = findTeam.getMembers();

            System.out.println("===================");
            for (Member m :
                    findTeamMembers) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/

        emf.close();

    }
}
