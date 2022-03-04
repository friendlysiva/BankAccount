package com.BankAccountCaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.BankAccount;

public class AccountOperation {
	List<BankAccount> arraylist=null;
	Scanner sc=new Scanner(System.in);
	public void addAccount() {
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

			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			String user="root";
			String pass="sivakumar";
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst =null; 
			pst=con.prepareStatement("insert into account(accountnumber,accounttype,firstname,lastname,address,"
					+ "contact,balance) values(?,?,?,?,?,?,?)");

			pst.setInt(1,acnumber);
			pst.setString(2, actype);
			pst.setString(3, fname);
			pst.setString(4, lname);
			pst.setString(5, address);
			pst.setString(6, contact);
			pst.setDouble(7, balance);
			int i = pst.executeUpdate();
			if(i!=0){
				System.out.println("added");
			}
			else{
				System.out.println("failed to add");
			}


		}catch(Exception e) {
			System.out.println(e);
		}
	}
public void modify() {
	
	try {

		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pass="sivakumar";
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst =null; 
		pst=con.prepareStatement("insert into account(accountnumber,accounttype,firstname,lastname,address,"
				+ "contact,balance) values(?,?,?,?,?,?,?)");

		int i = pst.executeUpdate();
		if(i!=0){
			System.out.println("added");
		}
		else{
			System.out.println("failed to add");
		}


	}catch(Exception e) {
		System.out.println(e);
	}
	 
	
	
}
}
