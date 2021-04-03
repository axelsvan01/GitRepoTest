package org.facade;

import java.util.List;

import javax.ejb.Local;

import org.ejb.Customer;
import org.ejb.Workout;

@Local
public interface FacadeLocal {

	//Customer
	public Customer findCustomerByPnr(String pnr); 
	public Customer createCustomer (Customer customer); 
	public Customer updateCustomer (Customer c); 
	public void deleteCustomer (String pnr); 
	public List<Customer> findAllCustomers(); 
	public void createBooking (String pnr, String code); 
	public void removeBooking (String pnr, String code); 
	
	//Workout
	public Workout findWorkoutByCode (String code);
	public Workout createWorkout (Workout workout);
	public Workout updateWorkout (Workout workout);
	public void deleteWorkout (String code);
	public List<Workout> findAllWorkout();
	 
}
