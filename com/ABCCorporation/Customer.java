package com.ABCCorporation;
import java.util.Scanner;
public class Customer {
	private int id;
	private String name;
	private String mobileNo;
	private String password;
	
	public Customer(int id, String name, String mobileNo, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", password=" + password + "]";
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addCustomer(){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Customer you want to add?");
		int user=sc.nextInt();
		if(user<=7){
			for(int i=cust.length;i<=user;i++)
		}
		
	}
	
}
