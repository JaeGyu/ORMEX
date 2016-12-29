package jpabook.chap08;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Member_p296Test {

	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void testMember_p296_1() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Team_p296 team = new Team_p296("team1", "영업");
			em.persist(team);

			Member_p296 member = new Member_p296("member1", "홍길동");
			member.setTeam(team);
			em.persist(member);
			tx.commit();

			// tx.begin();
			// Member_p296 findMem = em.find(Member_p296.class, "member2");
			// System.out.println(findMem);
			//
			// Team_p296 team_p296 = (findMem != null) ? findMem.getTeam() :
			// null;
			// System.out.println(team_p296);
			// System.out.println((team_p296 != null) ? team_p296.getName() :
			// null);
			// tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Test
	public void testMember_p296_2() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Member_p296 member = em.find(Member_p296.class, "member1");
			Team_p296 team = member.getTeam();
			System.out.println(team.getName());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@AfterClass
	public static void dropDown() throws Exception {
		emf.close();
	}
}
