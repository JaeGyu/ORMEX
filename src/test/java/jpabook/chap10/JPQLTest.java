package jpabook.chap10;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPQLTest {
	EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void ex_10_8() throws Exception {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//			tx.begin();
//			Member_p354 member = new Member_p354();
//			member.setUsername("alice");
//			member.setAge(11);
//			em.persist(member);
//			tx.commit();
//
//			tx.begin();
//			TypedQuery<Member_p354> query = em.createQuery("select m from Member_p354 m", Member_p354.class);
//
//			List<Member_p354> resultList = query.getResultList();
//
//			for (Member_p354 mem : resultList) {
//				System.out.println("member = " + mem);
//			}
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
	}

	@After
	public void dropDown() {
		emf.close();
	}
}
