package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Board b = new Board();
			b.setData("test");
			Board b2 = new Board();
			b2.setData("test2");

			em.persist(b);
			em.persist(b2);

			System.out.println("id : " + b.getId());
			System.out.println("id : " + b2.getId());

			tx.commit();
			tx.begin();
			Board c = new Board();
			c.setData("test");
			em.persist(c);
			System.out.println("id : " + c.getId());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();

	}
}
