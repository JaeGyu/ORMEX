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
public class MemberTest {

	private static EntityManagerFactory emf = null;

	@BeforeClass
	public static void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void p290_1() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Member_p290 member = new Member_p290("member1","alice");
			em.persist(member);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	@Test
	public void p290_2() throws Exception{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			//프록시 객체를 반환 한다.
			Member_p290 member = em.getReference(Member_p290.class, "member1");
			System.out.println(member.getUsername());
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
