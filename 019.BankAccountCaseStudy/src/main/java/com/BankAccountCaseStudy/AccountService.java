package com.BankAccountCaseStudy;

import java.util.Scanner;

import com.BankAccountCaseStudy.*;
import com.bean.BankAccount;

public class AccountService  {

	public static void main(String[] args) {
		int choice;
		Scanner sc=new Scanner(System.in);

		
		System.out.println();
		System.out.print("\n Enter your Choice:\n1. Add Account\r\n"
				+ "2. Show All Accounts\r\n"
				+ "3. Modify Account\r\n"
				+ "4. Delete Account\r\n"
				+ "5. Show Person Account\r\n"
				+ "6. Deposit\r\n"
				+ "7. Witdraw\r\n"
				+ "0. Terminate the app");
		
		choice=sc.nextInt();
		MenuClass mc=new MenuClass();
		
		
		
		//1. added new record
		switch(choice) {
		case 1:
			mc.addAccount();
			new AccountService().main(args);
		    break;
	         
		case 2:
		      mc.showAllAccount();
		      new AccountService().main(args);
		break;
		case 3:
			mc.modify();
			new AccountService().main(args);
			break;
		case 4:
			mc.delete();
			new AccountService().main(args);
			break;
		case 5:
			mc.showOneBalance();
			new AccountService().main(args);
			break;
		case 6:
			mc.deposit();
			new AccountService().main(args);
			break;
		case 7:
			mc.withdraw();
			new AccountService().main(args);
			break;
		case 0:
			System.exit(0);
			break;
			
		}
	
		
	}

}
