package jpabook.start;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPATest {
	private EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void 동일성_테스트() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("a", "aa");

		System.out.println(map.get("a") == new String("aa"));
		System.out.println(map.get("a") == "aa");
		System.out.println(map.get("a").equals(new String("aa")));
	}

	@Test
	public void 준영속() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			business(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private void business(EntityManager em) {
		Member m1 = new Member();
		m1.setAge(11);
		m1.setId("1");
		m1.setUsername("alice");

		em.persist(m1);

		em.detach(m1);

	}

	@After
	public void dropDown() throws Exception {
		emf.close();
	}

}
