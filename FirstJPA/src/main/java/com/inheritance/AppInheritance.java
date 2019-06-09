package com.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppInheritance {

	public AppInheritance() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {


			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("studentPU");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();

			Car st= new Car("toyota",180);
			em.persist(st);

			Bus p1= new Bus("Mtsubishi",47);
			em.persist(p1);

			//persistir con un commit, remove o persist
			em.getTransaction().commit();

			//cerrar la transaccion
			em.clear();
			emFactory.close();

		} catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

}
