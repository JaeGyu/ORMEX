package jpabook.chap06;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Chap06Test {

	EntityManagerFactory emf = null;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void Member_p206() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Team_p206 team = new Team_p206("영업");
			em.persist(team);

			Member_p206 member = new Member_p206("alice", team);
			em.persist(member);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@After
	public void dropDown() throws Exception {
		emf.close();
	}
}
