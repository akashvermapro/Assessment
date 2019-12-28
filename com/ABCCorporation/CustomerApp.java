package com.ABCCorporation;
import java.util.Scanner;
public class CustomerApp{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		Customer[] cust=new Customer[10];
		cust[0]= new Customer(101,"Akash Verma","7777777777","qwerty123");
		cust[1]= new Customer(102,"Vishva Variya","8888888888","qwerty123");
		cust[2]= new Customer(103,"Rahul Dubey","9999999999","qwerty123");
		
		String id,password;
		System.out.println("\t\tLogin");
		System.out.println("Enter ID: ");
		id = sc.next();
		System.out.println("Password: ");
		password = sc.next();
		if(id.equals("ABCCust")&&password.equals("abc@123")){
			System.out.println("Select Operation To Perform");
			System.out.println("1. Add New Customer");
			System.out.println("2. Display Customers");
			System.out.println("3. Edit Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");
			int ch=sc.nextInt();
			do{
				switch(ch)
				{
				case 1:
					addCustomer();
					break;
				case 2:
					displayCustomer();
					break;
				case 3:
					editCustomer();
					break;
				case 4:
					deleteCustomer();
					break;
				}
			}while(ch!=5);
		}
		else{
			System.out.println("Invalid User ID or Password");
		}
	}
}
