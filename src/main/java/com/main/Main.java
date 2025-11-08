package com.main;

import java.util.Scanner;

import com.dao.AccountDao;
import com.dao.CustomerDao;
import com.entity.Account;
import com.entity.Customer;

/**
 * @Author Hariprasanth 
 * 
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter 1 to create account");
		
		System.out.println("Enter 2 to create Customer");
		
		System.out.println("Enter 3 to allocate customer to account");
		
		System.out.println("Enter 4 to deallocate the customer to account");
		
		
		System.out.println("Enter 5 to find all the Account");
		
		System.out.println("Enter 6 to find all the Customer");
		
		System.out.println("Enter 7 to find by Balance");
		
		System.out.println("Enter 8 to find by branch");
		
		System.out.println("Enter 9 to update Email");
		

		switch(scan.nextInt()) {
		case 1:
		Account a=new Account();
		System.out.println("Enter the Account Number");
		a.setAccount_no(scan.nextInt());
		System.out.println("Enter the Balance");
		a.setBalance(scan.nextDouble());
		System.out.println("Enter the Ifsc");
		a.setIfsc(scan.next());
		System.out.println("Enter the Branch");
		a.setBranch(scan.next());
        AccountDao.insertAccount(a);
        break;
		case 2:
			Customer c=new Customer();
			System.out.println("Enter the Email");
			c.setEmail(scan.next());
			System.out.println("Enter the Name");
			c.setName(scan.next());
			System.out.println("Enter the Phone");
			c.setPhone(scan.nextLong());
		    CustomerDao.insertCustomer(c);
		    
		    break;
		case 3:
			System.out.println("Enter phone no");
			long phone=scan.nextLong();
			System.out.println("Enter the account");
			Integer acno=scan.nextInt();
			AccountDao.allocateAccount(phone, acno);
			break;
		case 4:
			System.out.println("Enter the Account no");
			AccountDao.deallocateAccount(scan.nextInt());
			break;
			
		case 5:
			AccountDao.findAllAccount();
			break;
		case 6:
			CustomerDao.findAllCustomer();
			break;
		case 7:
			System.out.println("Enter the amount");
			System.out.println(AccountDao.findByBalance(scan.nextDouble()));
			break;
		case 8:
			System.out.println("Enter the Branch");
			System.out.println(AccountDao.findByBranch(scan.next()));
			break;
		case 9:
			System.out.println("enter old email");
			String old=scan.next();
			System.out.println("enter new mail");
			String newString=scan.next();
			CustomerDao.updateEmail(old, newString);
			
			
			
		}
	}
}
