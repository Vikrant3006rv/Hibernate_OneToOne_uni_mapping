package OneToOne_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_uni.dto.AdharCard;

public class AdharCardDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikrant");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void dislpayAdharCard(int id) {

		System.out.println(em.find(AdharCard.class, id));
	}
	
	public void displayAllAdharCard() {
		
		Query query = em.createQuery("select a from AdharCard a");
		System.out.println(query.getResultList());
	}

	public void deleteAdhar(int id) {

		AdharCard ac = em.find(AdharCard.class, id);
		et.begin();
		em.remove(ac);
		et.commit();
	}

}
