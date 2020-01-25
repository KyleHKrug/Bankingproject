package com.revature.banking.test;



public class main {
	public static void main(String [] args) {
//		example of how to write to the specific file
		Customer customer = new Customer();
		customer.loginCustomer();
		ObjectIO rObj = new ObjectIO();
//		customer.NewAccount();
//		rObj.writeObject(customer, customer.getFileloc()+customer.getId());
		customer = (Customer) rObj.readObject(customer, customer.getFileloc() + "010101");
		System.out.println(customer.getFirst_name());
		//customer = (Customer)readObject;
		
		//ObjectIO object = new ObjectIO();
		//object.readObject(object, "00001");
		
		
		//Customer customer = new Customer();
		

		//customer.loginCustomer();
		
		//Employee employee = new Employee();
		//employee.view_customer(customer);
	
		//Admin admin = new Admin();
		//admin.adminLogin();

	}	
}

