package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainChap05_1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();

		try {
			tx.begin();
			TeamChap05 team1 = new TeamChap05("team1", "팀1");
			em.persist(team1);
			
			MemberChap05 member1 = new MemberChap05("member1", "회원1");
			member1.setTeam(team1);
			team1.getMembers().add(member1);
			em.persist(member1);
			
			MemberChap05 member2 = new MemberChap05("member2", "회원2");
			member2.setTeam(team1);
			team1.getMembers().add(member2);
			em.persist(member2);
			
			tx.commit();
			tx2.begin();
			TeamChap05 team  = em.find(TeamChap05.class, "team1");
			System.out.println("팀 : " + team);
			System.out.println("팀원들 : "+team.getMembers());
			
			for(MemberChap05 m : team.getMembers()){
				System.out.println(m);
			}
			
			tx2.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em2.close();
			em.close();
		}
		
		emf.close();
	}
}
