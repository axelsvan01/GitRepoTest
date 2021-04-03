package org.facade;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.eao.CustomerEAOLocal;
import org.eao.WorkoutEAOLocal;
import org.ejb.Customer;
import org.ejb.Workout;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private CustomerEAOLocal customerEAO; 
	
	@EJB 
	private WorkoutEAOLocal workoutEAO; 
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
       
    //CustomerEAO
    public Customer findCustomerByPnr(String pnr) {
    	return customerEAO.findByPnrId(pnr); 
    }
    
    public Customer createCustomer (Customer customer) {
    	return customerEAO.createCustomer(customer); 
    }

    public Customer updateCustomer (Customer customer) {
    	return customerEAO.updateCustomer(customer); 
    }
    
    public void deleteCustomer (String pnr) {
    	customerEAO.deleteCustomer(pnr);
    }
    
    public List<Customer> findAllCustomers(){
    	return customerEAO.findAll(); 
    }
    
    public void createBooking (String pnr, String code) { //Return void or Workout/Customer? 
    	Customer customer = customerEAO.findByPnrId(pnr);
    	Workout workout = workoutEAO.findByCode(code); 
    	
    	if (customer != null) {
    		Set<Workout> bookings = customer.getBookings(); 
    		if(workout != null) {
    			bookings.add(workout);
    			customer.setBookings(bookings);
    			customerEAO.updateCustomer(customer); 
    		}
    	}
    }
    
    public void removeBooking (String pnr, String code) { //Return void or Workout/Customer? 
    	Customer customer = customerEAO.findByPnrId(pnr);
    	Workout workout = workoutEAO.findByCode(code); 
    	
    	if (customer != null) {
    		Set<Workout> bookings = customer.getBookings(); 
    		if(workout != null) {
    			for(Workout tempW : bookings) {
    				if (tempW == workout) {
    					bookings.remove(workout);
    					customer.setBookings(bookings);
    					customerEAO.updateCustomer(customer); 
    				}
    			}
    		}
    	}
    }
    
    //WorkoutEAO
    public Workout findWorkoutByCode (String code) {
    	return workoutEAO.findByCode(code);
    }
    
    public Workout createWorkout (Workout workout) {
    	return workoutEAO.createWorkout(workout); 
    }
    
    public Workout updateWorkout (Workout workout) {
    	return workoutEAO.updateWorkout(workout);
    }

    public void deleteWorkout (String code) {
    	workoutEAO.deleteWorkout(code);
    }
    
    public List<Workout> findAllWorkout(){
    	return workoutEAO.findAll();
    }
}
