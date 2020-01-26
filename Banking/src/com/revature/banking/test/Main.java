package com.revature.banking.test;

public class Main {
	public static void main(String [] args) {
		
//		example of how to write to the specific file

		
		//Admin admin = new Admin();
		//admin.getCustomer();
		

		Customer customer = new Customer();
		ObjectIO rObj = new ObjectIO();
		customer.NewAccount();
		rObj.writeObject(customer, customer.getFileloc()+customer.getId());
		customer = (Customer) rObj.readObject(customer, customer.getFileloc() + "00001");
		System.out.println(customer.getFirst_name());
		
		
//		Customer customer = new Customer();
//		ObjectIO wObj = new ObjectIO();
//		customer.NewAccount();
//		wObj.writeObject(customer, customer.getFileloc() + customer.getId());
//		ObjectIO rObj = new ObjectIO();
//		rObj.readObject(customer, customer.getFileloc() + customer.getId());
		
		//ObjectIO object = new ObjectIO();
		//object.readObject(object, "00001");
			
		//customer.loginCustomer();
		//Employee employee = new Employee();
		//employee.employeeMenu();
	
		//Admin admin = new Admin();
		//admin.adminLogin();

	}	
}

