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
	
	public static void deleteAccountById(Integer aco) {
		entityManager.getTransaction().begin();
		entityManager.remove(findAccountById(aco));
		entityManager.getTransaction().commit();
	}
	
	public static void deallocateAccount(Integer acno) {
		Account a=findAccountById(acno);
		a.setCustomer(null);
		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();	
	}
	
	public static void findAllAccount() {
		entityManager.createQuery("Select a from Account a").getResultList()
		.forEach(System.out::println);
	}
	
	public static void updateAccountBalance(Integer acno,Double balance) {
		Account a=findAccountById(acno);
		a.setBalance(balance);
		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();
	}
	
	public static void updateAccountBranch(Integer acno,String branch) {
		Account a=findAccountById(acno);
		a.setBranch(branch);
		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();
	}
	
	public static void updateAccountIfsc(Integer acno,String ifsc) {
		Account a=findAccountById(acno);
		a.setBranch(ifsc);
		entityManager.getTransaction().begin();
		entityManager.merge(a);
		entityManager.getTransaction().commit();
	}
}
