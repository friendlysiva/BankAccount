package com.bean;

public class BankAccount {
	private Integer accountNumber;
    private String accountType;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private double balance;
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount() {
		
	}
	public BankAccount(Integer accountNumber, String accountType, String firstName, String lastName, String address,
			String contactNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "\naccountNumber=" + accountNumber + ", accountType=" + accountType + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", balance=" + balance ;
	}
    

}
