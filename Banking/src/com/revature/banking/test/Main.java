package com.revature.banking.test;

public class Main {
	public static void main(String [] args) {
		
//		example of how to write to the specific file

		
		//Admin admin = new Admin();
		//admin.getCustomer();
		
		
		Customer customer = new Customer();
		ObjectIO wObj = new ObjectIO();
		customer.NewAccount();
		wObj.writeObject(customer, customer.getFileloc() + customer.getId());
		ObjectIO rObj = new ObjectIO();
		rObj.readObject(customer, customer.getFileloc() + customer.getId());
		
		//ObjectIO object = new ObjectIO();
		//object.readObject(object, "00001");
			
		//customer.loginCustomer();
		
		//Employee employee = new Employee();
		//employee.view_customer(customer);
	
		//Admin admin = new Admin();
		//admin.adminLogin();

	}	
}

