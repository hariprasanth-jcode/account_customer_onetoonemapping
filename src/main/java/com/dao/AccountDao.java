package com.dao;

import javax.persistence.EntityManager;

import com.entity.Account;
import com.entity.Customer;
import com.util.Connection;

public class AccountDao {

	private static EntityManager entityManager = Connection.getEntityManager();

	public static void insertAccount(Account a) {
		entityManager.getTransaction().begin();
		entityManager.persist(a);
		entityManager.getTransaction().commit();
	}
	
	public static void allocateAccount(long phone,Integer acno) {

		Account a=findAccountById(acno);
		Customer c=CustomerDao.findCustomerByPhone(phone);
		a.setCustomer(c);
		entityManager.getTransaction().begin();
		entityManager.merge(c);
		entityManager.getTransaction().commit();
	}
	
	public static Account findAccountById(Integer acno) {
       return entityManager.find(Account.class, acno);
	}
}
