package com.mappedSuperClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.inheritance.Bus;
import com.inheritance.Car;

public class AppMappedSuperClass {

	public static void main(String[] args) {
		try {


			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("studentPU");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();

			StudentPerson st= new StudentPerson();
			st.setAge("18");
			st.setName("John");
			st.setDrivingLicence("1234656789");
			em.persist(st);

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
