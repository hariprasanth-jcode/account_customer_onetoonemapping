package com.dao;

import javax.persistence.EntityManager;

import com.entity.Account;
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
	
	public static void findAllCustomet() {
		entityManager.createQuery("Select c from Customer c").getResultList()
		.forEach(System.out::println);
	}
}
