package com.main;

import com.dao.AccountDao;
import com.dao.CustomerDao;
import com.entity.Account;
import com.entity.Customer;

public class Main {

	public static void main(String[] args) {

		
//		Customer c=new Customer();
//		c.setEmail("allen@gmail.com");
//		c.setName("allen");
//		c.setPhone(987654321l);
//		
//		CustomerDao.insertCustomer(c);
//		
//		Account a=new Account();
//		a.setAccount_no(1);
//		a.setBalance(20000.0);
//		a.setBranch("Pune");
//		a.setIfsc("ICICI123");
//		
//		AccountDao.insertAccount(a);
		
		
		
		CustomerDao.deleteByCustomerPhone(987654321);
		//AccountDao.deleteAccountById(1);
	}
}
