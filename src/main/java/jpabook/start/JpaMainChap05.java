package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainChap05 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			/*
			 * 모든 엔티티는 영속상태로 만들어 놓고 나서 조작을 해야 한다.
			 */
			tx.begin();
			TeamChap05 team1 = new TeamChap05("team1", "팀1");
			em.persist(team1);

			MemberChap05 member1 = new MemberChap05("member1", "회원1");
			member1.setTeam(team1);
			em.persist(member1);

			MemberChap05 member2 = new MemberChap05("member2", "회원2");
			member2.setTeam(team1);
			em.persist(member2);

			tx.commit();
			tx.begin();
			MemberChap05 member = em.find(MemberChap05.class, "member1");
			TeamChap05 team = member.getTeam();
			System.out.println("================================");
			System.out.println("팀 이름 = " + team.getName());
			System.out.println("================================");
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
	}
}
