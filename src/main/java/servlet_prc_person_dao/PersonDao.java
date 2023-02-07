package servlet_prc_person_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlet_prc_person_dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	//to save
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	//to update
	public void updatePerson(String email,Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person receivedPerson=entityManager.find(Person.class, email);
		if(receivedPerson!=null) {
			person.setEmail(email);
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person doesn't exists");
		}
		
	}
	//giving email id and fetch password(login)
	public String login(String email) {
		EntityManager entityManager=getEntityManager();
		String jpql="select p from Person p where p.email=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, email);
		Person person=(Person)query.getSingleResult();
		String  password=person.getPassword();
		return password;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
