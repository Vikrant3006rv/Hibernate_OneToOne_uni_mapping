package OneToOne_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_uni.dto.AdharCard;
import OneToOne_uni.dto.Person;

public class PersonDao {

	private static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vikrant").createEntityManager();
		// TODO Auto-generated method stub

	}

	public void savePerson(Person p1) {
		// TODO Auto-generated method stub
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		AdharCard ac1 = p1.getAdharCard();

		et.begin();
		em.persist(ac1);
		em.persist(p1);
		et.commit();
	}

	public void deletePerson(int id) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Person ps = em.find(Person.class, id);
		AdharCard ac = ps.getAdharCard();

		et.begin();
		em.remove(ac);
		em.remove(ps);
		et.commit();

	}

	public void displayPerson(int id) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		System.out.println(em.find(Person.class, id));
	}

	public void displayAllPerson() {

		EntityManager em = getEntityManager();
		Query query = em.createQuery("select p from Person p");
		System.out.println(query.getResultList());
	}

	public void updatePerson(Person p1) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		AdharCard ac = p1.getAdharCard();

		et.begin();
		em.merge(ac);
		em.merge(p1);
		et.commit();
	}

	public void updatePerson(Person p1, int id) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Person dbp1 = em.find(Person.class, id);

		if (dbp1 != null) {

			p1.setId(id);
			p1.setAdharCard(dbp1.getAdharCard());
			et.begin();
			em.merge(p1);
			et.commit();
		}
	}

	public void updatePerson(int pid, int aid) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p1 = em.find(Person.class, pid);
		AdharCard ac = em.find(AdharCard.class, aid);

			p1.setAdharCard(ac);
			et.begin();
			em.merge(p1);
			et.commit();
		}
}
