package com.relationship.manyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppRelationshipManyToMany {

	public AppRelationshipManyToMany() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Professor pp1= new Professor("cholo la quimica");
		Professor pp2= new Professor("juan la bala");
		
		Project pj1= new Project("deporte");
		Project pj2 = new Project("mistolin");
		Project pj3 = new Project("paseo");
		
		pp1.assingProjectToProfessor(pj1);
		pp2.assingProjectToProfessor(pj3);
		pp1.assingProjectToProfessor(pj3);
		
		pj1.assingProfessorToProject(pp1);
		pj1.assingProfessorToProject(pp2);
		pj3.assingProfessorToProject(pp2);
		
		em.persist(pp1);
		em.persist(pp2);
		
		em.persist(pj1);
		em.persist(pj2);
		em.persist(pj3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
