package org.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ejb.Customer;

/**
 * Session Bean implementation class CustomerEAOImpl
 */
@Stateless
public class CustomerEAOImpl implements CustomerEAOLocal {

	@PersistenceContext(unitName="AssignmentEJBSql")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public CustomerEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Customer findByPnrId (String pnr) {
    	return em.find(Customer.class, pnr); 
    }
    
    public Customer createCustomer (Customer customer) {
    	em.persist(customer);
    	return customer; 
    }
    
    public Customer updateCustomer (Customer customer) {
    	em.merge(customer); 
    	return customer; 
    }
    
    public void deleteCustomer (String pnr) {
    	Customer customer = this.findByPnrId(pnr);
    	if(customer != null) {
    		em.remove(customer);
    	}
    }
    
    public List<Customer> findAll(){
    	TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class); 
    	
    	List<Customer> result = query.getResultList(); 
    	return result; 
    }
}
