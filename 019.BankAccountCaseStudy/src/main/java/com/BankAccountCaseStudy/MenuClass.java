package com.BankAccountCaseStudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.bean.BankAccount;

public class MenuClass {
	
			Session session=new Configuration()
				.configure("hibernate1.cfg.xml")
				.buildSessionFactory()
				.openSession();
	
		
		List<BankAccount> arraylist=null;
		Scanner sc=new Scanner(System.in);
	public  void addAccount() {
		arraylist=new ArrayList<BankAccount>();
		BankAccount account=new BankAccount();
		System.out.println("enter account number");
		int acnumber=sc.nextInt();
		account.setAccountNumber(acnumber);
		System.out.println("enter account type");
		String actype=sc.next();
		account.setAccountType(actype);
		System.out.println("enter FirstName");
		String fname=sc.next();
		account.setFirstName(fname);
		System.out.println("enter LastNmae");
		String lname=sc.next();
		account.setLastName(lname);
		System.out.println("enter Address");
		String address=sc.next();
		account.setAddress(address);
		System.out.println("enter Contact Number");
		String contact=sc.next();
		account.setContactNumber(contact);
		System.out.println("Enter Opening Amount");
		double balance=sc.nextDouble();
		account.setBalance(balance);
		try {
			
			Transaction tx=null;
			
			tx=session.beginTransaction();
			session.save(account);
			tx.commit();
			System.out.print("\n Record  has been added successfully...");
		}catch(HibernateException e) {
			System.err.print("\n"+e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void showAllAccount() {
		List<BankAccount> list=null;
		int rec=0;
		try {
			Session session=new Configuration()
					.configure("hibernate1.cfg.xml")
					.buildSessionFactory()
					.openSession();
			list=session.createQuery("from BankAccount").list();
			Iterator <BankAccount>itr=list.iterator();
			while(itr.hasNext()) {
				System.out.print("\n"+itr.next());
				rec++;
			}
		}catch(HibernateException e) {
			System.err.print("\n"+e.getMessage());
		}finally {
			if(rec>0) {
				System.out.print("\n "+rec+" Records found...");
			}else {
				System.err.print("\n No Record found...");
			}	
		}
	}
	
	public static void showOneBalance() {
		Scanner sc=new Scanner(System.in);
		Transaction tx=null;
		try {
			Configuration con=new Configuration();
			con.configure("hibernate1.cfg.xml");
			SessionFactory factory= con.buildSessionFactory();
			Session session= factory.openSession();
			tx=session.beginTransaction();
			System.out.println("Enter account number for show balance");
			int i=sc.nextInt();
			BankAccount account=new BankAccount();
			account=session.get(BankAccount.class, i);
			
		if(account==null) {
			System.err.print("\nNo record found for id:"+i);
		}else {
		System.out.print(account.getBalance());
		
		}
		}catch(HibernateException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void modify() {
		Scanner sc=new Scanner(System.in);
		Transaction tx=null;
		try {
			Configuration con=new Configuration();
			con.configure("hibernate1.cfg.xml");
			SessionFactory factory= con.buildSessionFactory();
			Session session= factory.openSession();
			tx=session.beginTransaction();
			System.out.println("Enter Account number for update contact");
			int i=sc.nextInt();
			BankAccount account=session.get(BankAccount.class, i);
			System.out.println("Enter Contact number:");
			account.setContactNumber(sc.next());
			session.update(account);
			tx.commit();
			session.close();
		
		}catch(HibernateException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void delete() {
		Scanner sc=new Scanner(System.in);
		Transaction tx=null;
		
		try {
			Configuration con=new Configuration();
			con.configure("hibernate1.cfg.xml");
			SessionFactory factory= con.buildSessionFactory();
			Session session= factory.openSession();
			tx=session.beginTransaction();
			System.out.println("Enter Account number for Delete account");
			int i=sc.nextInt();
			BankAccount account=session.get(BankAccount.class, i);
		session.delete(account);
		tx.commit();
		session.close();
		}catch(HibernateException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public static void deposit() {
		Scanner sc=new Scanner(System.in);
		Transaction tx=null;
		try {
			Configuration con=new Configuration();
			con.configure("hibernate1.cfg.xml");
			SessionFactory factory= con.buildSessionFactory();
			Session session= factory.openSession();
			tx=session.beginTransaction();
			System.out.println("Enter Account number for Deposit");
			int i=sc.nextInt();
			BankAccount account=session.get(BankAccount.class, i);
			System.out.println("Enter Deposit Amount:");
			double amount=sc.nextDouble();
			if(amount>=1000) {
				amount+=account.getBalance();
			account.setBalance(amount);
			session.update(account);
			tx.commit();
			session.close();
			System.out.println("Deposit Success");
			}else {
				System.err.println("Please Deposit above 1000");
			}
		
		}catch(HibernateException e) {
			System.err.println(e.getMessage());
		}
	}
		public static void withdraw() {
			Scanner sc=new Scanner(System.in);
			Transaction tx=null;
			try {
				Configuration con=new Configuration();
				con.configure("hibernate1.cfg.xml");
				SessionFactory factory= con.buildSessionFactory();
				Session session= factory.openSession();
				tx=session.beginTransaction();
				System.out.println("Enter Account number for withdraw");
				int i=sc.nextInt();
				BankAccount account=session.get(BankAccount.class, i);
				System.out.println("Enter Withdraw Amount:");
				double amount=sc.nextDouble();
			
				if(amount>=1000 && account.getBalance()>=5000) {
					double balance=account.getBalance()-amount;
					 if (balance>=5000) {
					amount=account.getBalance()-amount;
				account.setBalance(amount);
				session.update(account);
				tx.commit();
				session.close();
				System.out.println("Withdraw Success");
				}else {
					System.err.println("Your account balance is low");
				}
					 System.err.println("You can not withdraw below 1000");
				}
				
			}catch(HibernateException e) {
				System.err.println(e.getMessage());
			}
	}
	

}
