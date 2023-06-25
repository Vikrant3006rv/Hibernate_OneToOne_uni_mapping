package OneToOne_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToOne_uni.dao.AdharCardDao;
import OneToOne_uni.dao.PersonDao;
import OneToOne_uni.dto.AdharCard;
import OneToOne_uni.dto.Person;

public class Main {

	public static void main(String[] args) {

		AdharCard ac = new AdharCard();

		ac.setId(101);
		ac.setName("Ajit");
		ac.setAddress("Salekasa");

		Person p1 = new Person();

		p1.setId(1);
		p1.setName(ac.getName());
		p1.setPhone(779840223);
		p1.setAdharCard(ac);

		AdharCard ac1 = new AdharCard();

		ac1.setId(102);
		ac1.setName("Rahul");
		ac1.setAddress("Amgaon");

		Person p2 = new Person();

		p2.setId(2);
		p2.setName(ac1.getName());
		p2.setPhone(9322143547l);
		p2.setAdharCard(ac1);

		PersonDao pd = new PersonDao();
		AdharCardDao ad = new AdharCardDao();
		
		ad.displayAllAdharCard();
		
//		pd.updatePerson(p1, 101);

//		pd.savePerson(p1);
//		pd.savePerson(p2);
		
//		pd.displayPerson(1);
//		pd.displayAllPerson();

//		pd.deleteAdhar(101);
//		pd.deletePerson(10); // enter id of person
		
		

	}
}
