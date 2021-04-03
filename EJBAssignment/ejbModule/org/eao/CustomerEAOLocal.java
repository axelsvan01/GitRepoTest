package org.eao;

import java.util.List;

import javax.ejb.Local;

import org.ejb.Customer;

@Local
public interface CustomerEAOLocal {
	
	public Customer findByPnrId (String pnr); 
	public Customer createCustomer (Customer customer);
	public Customer updateCustomer (Customer customer); 
	public void deleteCustomer (String pnr); 
	public List<Customer> findAll(); 
}
