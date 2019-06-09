package com.relationship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppRelationship {

	public AppRelationship() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("studentPU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Location lc= new Location(1234, "Bayona");
		
		Employee emp= new Employee();
		emp.setName("Juan mendoza");
		
		emp.setLocation(lc);
		lc.setEmployee(emp);
		
		em.persist(emp);
		em.persist(lc);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
