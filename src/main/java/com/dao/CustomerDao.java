package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Customer;
import com.util.Connection;

public class CustomerDao {

	private static EntityManager entityManager=Connection.getEntityManager();
	
	public static void insertCustomer(Customer c) {
    entityManager.getTransaction().begin();
    entityManager.persist(c);
    entityManager.getTransaction().commit();
	}
	
	public static Customer findCustomerByPhone(long phone) {
		return entityManager.find(Customer.class, phone);
	}
	
	public static void deleteByCustomerPhone(long phone) {
		entityManager.getTransaction().begin();
		entityManager.remove(findCustomerByPhone(phone));
		entityManager.getTransaction().commit();
	}
	
	public static void findAllCustomer() {
		entityManager.createQuery("Select c from Customer c").getResultList()
		.forEach(System.out::println);
	}
	public static void updateEmail(String oldEmail,String newEmail) {
		Query query=entityManager.createQuery("Update Customer c set c.email=?1 where c.email=?2");
	    query.setParameter(1, newEmail);
	    query.setParameter(2, oldEmail);
	    
	    entityManager.getTransaction().begin();
	    query.executeUpdate();
	    entityManager.getTransaction().commit();
	}
	public static void updateEmail(long phone,String email) {
		Customer c=findCustomerByPhone(phone);
		c.setEmail(email);
		entityManager.getTransaction().begin();
		entityManager.merge(c);
		entityManager.getTransaction().commit();
	}
	
	public static void updateName(long phone,String name) {
		Customer c=findCustomerByPhone(phone);
		c.setName(name);
		entityManager.getTransaction().begin();
		entityManager.merge(c);
		entityManager.getTransaction().commit();
	}
}
