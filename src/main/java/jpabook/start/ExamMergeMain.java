package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

	public static void main(String[] args) {
		Member member = createMember("memberA", "회원1");

		// member은 영속성컨텍스트의 관리를 받지 않고 있다. 준영속 상태이다.
		member.setUsername("회원명 변경");

		removeMemberA();
		//현재 memberA는 db에 존재 하지 않는 상태이다. 
		mergeMember(member);

		emf.close();
	}

	private static void removeMemberA() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Member memberA = new Member();
		memberA.setId("memberA");

		try {
			tx.begin();
			em.remove(memberA);// 에러 발생함 왜냐하면 위의 엔티티는 비영속상태이기 떄문에 영속성컨텍스트에의해 제어 될 수 없다. 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void mergeMember(Member member) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Member mergeMember = em.merge(member);
			tx.commit();

			System.out.println("member=" + member.getUsername());

			System.out.println("mergeMember=" + mergeMember.getUsername());
			System.out.println("em contains member = " + em.contains(member));
			System.out.println("em contains mergeMember = " + em.contains(mergeMember));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static Member createMember(String id, String username) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Member member = new Member();
		member.setId(id);
		member.setUsername(username);

		try {
			tx.begin();
			em.persist(member);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return member;
	}
}
