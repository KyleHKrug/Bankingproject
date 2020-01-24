package com.revature.banking.test;

public class Main {
	public static void main(String [] args) {
		//example of how to write to the specific file
//		Customer customer = new Customer();
//		ObjectIO wObj = new ObjectIO();
//		customer.NewAccount();
//		wObj.writeObject(customer,customer.getFileloc()+customer.getId() );
		Employee employee = new Employee();
		employee.employeeLogin();
		
		Customer customer = new Customer();
		customer.loginCustomer();
		
		Admin admin = new Admin();
		admin.adminLogin();

	}	
}

