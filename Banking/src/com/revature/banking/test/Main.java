package com.revature.banking.test;

import java.util.Scanner;

public class Main {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String [] args) {
			
		Customer customer = new Customer();
		Employee employee = new Employee();
		Admin admin = new Admin();
		ObjectIO rObj = new ObjectIO();
		ObjectIO wObj = new ObjectIO();

		Scanner scanningStan = new Scanner(System.in);
		String userType;
		
		System.out.println("Hello and welcome to Kyle and Alia's Bank!\n\nAre you a:\n");
		System.out.println("1. New customer?");
		System.out.println("2. Returning customer?");
		System.out.println("3. Employee?");
		System.out.println("4. Administrator?");
		
		userType = scanningStan.next();
		
		switch(userType) {
		
			case "1":

				String choices;
				System.out.println("\nWelcome valued new customer!");
				System.out.println("Would you like to:");
				System.out.println("1. Create an account?");
				System.out.println("2. Go away?");
				choices = scanningStan.next();
				
				if(choices.equals("1")) {
										
					customer.NewAccount();

					wObj.writeObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/" + customer.getId());
					
					System.out.println("Your account application is being processed! We'll get back to you shortly! Have a nice day!");

				}else {
					
					System.out.println("\nBye!");
					System.exit(0);
					
				}
				
				break;
				
			case "2":
				
				System.out.println("\nWelcome valued returning customer!");
			
				customer.loginCustomer();
				customer.menu(customer);
				
				break;
				
			case "3":
				
				employee.employeeLogin();
				employee.employeeMenu();
//				employee.approve(customer);
				
//				System.out.println("\nWelcome valued employee!");
//				System.out.println("What would you like to do today?");
//				
//				System.out.println("Please enter the user ID of the customer you wish to approve/deny!");
//				choices = scanningStan.next();
//				
//				customer = (Customer)rObj.readObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/" + choices);
//				
//				employee.approve(customer);
//																
//				wObj.writeObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/aa");
//				customer.isApproved();

				
				break;
				
			case "4":
				
				System.out.println("\nWelcome valued administrator!");
//				
//				admin.createEmployee();
//				
//				wObj1.writeObject(employee1, "/Users/aliareed/Bankingproject/Banking/Employee/");
//				
//				System.out.println("Welcome to the family, new employee!");
				
				break;
				
			default:
				
				break;
		}			
//		scanningStan.close();
	}
		
//	@SuppressWarnings("resource")
//	public static boolean mariosMenu() {
//	
//		return true;
				
		//customer.loginCustomer();
		//customer.newAccount();
	//	rObj.writeObject(customer, customer.getFileloc()+customer.getId());
	//	customer = (Customer) rObj.readObject(customer, customer.getFileloc() + "a");
	//	System.out.println(customer.getFirst_name());
		//customer = (Customer)readObject;

		//object.readObject(object, "00001");

		//customer.loginCustomer();

		//employee.view_customer(customer);

		//admin.adminLogin();
//	}
		
}