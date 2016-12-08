package jpabook.start;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sandbox.model.entity.Student;

public class SandboxTest {
	EntityManagerFactory emf = null;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void createStudentTableAndInsertData() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Student s = new Student();
			s.setName("alice");
			s.setBirthday(new Date(System.currentTimeMillis()));
			
			em.persist(s);

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
