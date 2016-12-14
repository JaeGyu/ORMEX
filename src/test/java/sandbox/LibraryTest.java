package sandbox;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sandbox.model.entity.Book;
import sandbox.model.entity.Library;

public class LibraryTest {
	private EntityManagerFactory emf = null;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}

	@Test
	public void testInsert() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Library l1 = new Library("sk");
			em.persist(l1);
			
			Book book1 = new Book("JPA 배우기",32000);
			book1.setLibrary(l1);
			em.persist(book1);
			
			Book book2 = new Book("JAVA의 정석", 28000);
			book2.setLibrary(l1);
			em.persist(book2);
			
			Library ll = em.find(Library.class, l1.getId());
					
			System.out.println("도서관 :: "+ll.getBooks());
			
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
