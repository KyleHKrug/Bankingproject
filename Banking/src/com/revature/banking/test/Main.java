package com.revature.banking.test;

import java.util.Scanner;

public class Main {
	
	static Customer customer = new Customer();
	static Employee employee = new Employee();
	static Admin admin = new Admin();
	static ObjectIO rObj = new ObjectIO();
	static ObjectIO wObj = new ObjectIO();

	static Scanner scanningStan = new Scanner(System.in);
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String [] args) {
			
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
				System.out.println("Welcome back!");
				customer.menu(customer);
				
				break;
				
			case "3":
								
				employee.employeeLogin();
				
				actualWorkingEmployeeMenu();
				
//				employee.employeeMenu();
//				employee.approve(customer);		
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
				admin.createEmployee();
//				
				wObj.writeObject(employee, "/Users/aliareed/Bankingproject/Banking/Employee/");
//				
				System.out.println("Welcome to the family, new employee!");
				
				break;
				
			default:
				
				break;
		}
		
	}

	public static void actualWorkingEmployeeMenu() {
		
		System.out.println("\nWelcome valued employee!");
		System.out.println("What would you like to do today?");
						
		System.out.println("1. View view all customer information!");
		System.out.println("2. Approve a customer account!");
		System.out.println("3. Exit!");
		
		String useAGoddamnSwitchStatementKYLE = scanningStan.nextLine();
		
		switch(useAGoddamnSwitchStatementKYLE)	{
		
		case "1":

				employee.view_customer(customer);
				break;

		case "2":
			
				employee.approve(customer);
				break;

		case "3":
			
				System.out.println("Thanks for coming! Have a good day!");
				System.exit(0);
				
		default:
			
				System.out.println("Try again buster");
				break;
				
			}
		
	}
	
}