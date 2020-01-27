package com.revature.banking.test;

//import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Customer extends Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private double balance = 0.0;
	private boolean approved = false;
	private boolean disabled = false;
	private String fileloc = "/Users/aliareed/Bankingproject/Banking/Customer";
	//Used to display the balance to the second decimal place
	private static DecimalFormat df = new DecimalFormat("0.00");

	public void loginCustomer(){
		
		//System.out.println(new File(fileloc + "test.txt").getAbsolutePath());
		Customer customer = new Customer();

		try { 
			
			Scanner in = new Scanner(System.in);
			String id = null;
			boolean t = false;
			
			while(t == false) {

			System.out.println("Enter your ID number please!");
			id = in.nextLine();
			t = customer.checkNull(id);
			
			}

			String pass= null;
			boolean w = false;

			while(w == false) {
				
				System.out.println("Enter your password please!");
				pass = in.nextLine();
				w = customer.checkNull(pass);
				
			}

			Login check = new Login();
			ObjectIO robj = new ObjectIO();

			customer = (Customer) robj.readObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/" + id);
			String password = customer.getPassword();

			if(customer.isDisabled() == false) {

				if(customer.isApproved() == true) {
//
//					if(check.login(pass, password) == true) {
//
//						in.close();
//						menu(customer);
//
//					}else{
//						
//						System.out.println("Cannot log in, try again!");
//						loginCustomer();					
//					}
					
				}else{
					
					System.out.println("Your account has not been approved!");
					System.out.println("It will be approved shortly!");
				}
				
			}else{
				
				System.out.println("Your account has been disabled!");
				System.out.println("Please see a bank admin");
			}
		//	in.close();
		}catch (Exception ex) {
			
		//	loginCustomer();
			ex.getStackTrace();
			
		}
	}

	public void menu(Customer customer) {

		ObjectIO save = new ObjectIO();
		System.out.println("Your current balance is : $"+ df.format(customer.getBalance()));

		System.out.println("Press D to deposit an amount into your balance!");
		System.out.println("Press W to withdraw an amount from your balance!");
		System.out.println("Press T to transfer an amount to another member!");
		System.out.println("Press E to exit your account!");

		try (Scanner in = new Scanner(System.in)) {

			String c = in.nextLine();

					if( c != null) {

						if( c.equalsIgnoreCase("D")) {

							System.out.println("Enter the amount you wish to deposit!");
							double amount = in.nextDouble();

							customer.deposit(customer.getBalance(), amount);
							save.writeObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/" + customer.getId());
							menu(customer);

						}else if (c.equalsIgnoreCase("T")) {

							System.out.println("Enter the ID of the member you wish to transfer funds to!");
							String tCID = in.nextLine();
							
							System.out.println("Enter the amount you wish to transfer!");
							double amount = in.nextDouble();
							
							customer.transfer(tCID, customer.getId(), amount, customer);
							save.writeObject(customer, customer.getId());
							menu(customer);

						}else if (c.equalsIgnoreCase("W")) {

							System.out.println("Enter the amount you with to withdraw!");
							double amount = in.nextDouble();
							
							customer.withdraw(customer.getBalance(), amount);
							save.writeObject(customer, "/Users/aliareed/Bankingproject/Banking/Customer/" + customer.getId());
							menu(customer);

						}else if(c.equalsIgnoreCase("E")) {

							System.out.println("Thanks for coming! Have a good day!");
							System.exit(0);
							
						}else{

							System.out.println("Try again buster");
							menu(customer);
						}
						
					}else {

						System.out.println("Try again buster");
						menu(customer);
					}

					in.close();
		}
		
	}

	public void transfer(String tCID, String cID, double amount, Customer transferer) {

		// transfers money from one account to another
		//tcid is the transferee id 

		Customer transferee = new Customer();
		ObjectIO robj = new ObjectIO();
		ObjectIO wobj = new ObjectIO();
		
		transferee = (Customer)robj.readObject(transferee, "/Users/aliareed/Bankingproject/Banking/Customer/" + tCID);
		transferee.deposit(transferee.getBalance(), amount);
		transferer.withdraw(transferer.getBalance(), amount);

		wobj.writeObject(transferee, "/Users/aliareed/Bankingproject/Banking/Customer/" + transferee.getId());
		wobj.writeObject(transferer, "/Users/aliareed/Bankingproject/Banking/Customer/" + transferer.getId());
	}

	public void setBalance(double b) {
		this.balance = b;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double d, double amount) {

		// subtracts the amount from a user's balance
		double newbalance;

		if (amount > 0){

			if( amount < d) {

			newbalance = d - amount;
			setBalance(newbalance);

			}else {

				System.out.println("Withdraw amount is more than you have in your account!");
			}

		}else {

			System.out.println("You cannot withdraw a negative number!");
		}
	}

	public void deposit(double d, double amount) {

		// adds amount to the users balance
		double newbalance;
		newbalance = d + amount;
		setBalance(newbalance);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getFileloc() {
		return fileloc;
	}

	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}

} 