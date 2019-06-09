package com.javawebtutor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
	{
		try {


			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("studentPU");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();

			//			//grabar data
			//			Student st= new Student(21,"java member2",1);
			//			em.persist(st);

			//			//grabar data
			//			Person p1= new Person("Juan2","Juan2@gmal.com");
			//			em.persist(p1);

			//			//buscar por id
			//			Person p=em.find(Person.class, 4);
			//			System.out.println(p.toString());

			//			Query query=em.createQuery("SELECT p FROM Person p WHERE p.id >=3");
			//						List<Person> people = query.getResultList();
			//			
			//			for (Person person : people) {
			//				System.out.println(person);
			//			}

			//			TypedQuery<Person> query= em.createNamedQuery("person.getAll", Person.class);
			//
			//			List<Person>result=query.getResultList();
			//			
			//			for (Person person : result) {
			//				System.out.println(person);
			//			}

			//			TypedQuery<Person> query= em.createNamedQuery("person.getById", Person.class);
			//			query.setParameter("id", 2);
			//			List<Person>result=query.getResultList();
			//			
			//			for (Person person : result) {
			//				System.out.println(person);
			//			}

			//			em.remove(p);

			//persistir con un commit, remove o persist
			//			em.getTransaction().commit();

			//cerrar la transaccion
			em.clear();
			emFactory.close();

		} catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

}
