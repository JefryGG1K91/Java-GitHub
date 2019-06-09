package com.relationship.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.relationship.Employee;
import com.relationship.Location;

public class AppRelationshipManyToOne {

	public AppRelationshipManyToOne() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("studentPU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		University un= new University("UASD");
		
		StudentUniversity su= new StudentUniversity("Jefry");
		su.setUniversity(un);
		
		StudentUniversity su1= new StudentUniversity("Juan");
		su1.setUniversity(un);
		
		un.addStudent(su);
		un.addStudent(su1);
		
		em.persist(un);
		em.persist(su);
		em.persist(su1);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
