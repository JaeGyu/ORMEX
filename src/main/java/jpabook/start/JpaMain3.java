package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Member insertData = getMember();

			em.persist(insertData);

			Member memberA = em.find(Member.class, "1");
			System.out.println("결과는 : " + memberA);

			em.remove(memberA);
			System.out.println("삭제 후 : " + memberA); //이렇게 사용하면 안됨 영속성 컨텍스트에서는 지워져 있기 때문에...
			System.out.println("영속성 컨텍스트에서 찾아보기 : " + em.find(Member.class, "1"));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		emf.close();
	}

	private static Member getMember() {
		Member m = new Member();
		m.setAge(11);
		m.setId("1");
		m.setUsername("이런");
		return m;
	}
}
