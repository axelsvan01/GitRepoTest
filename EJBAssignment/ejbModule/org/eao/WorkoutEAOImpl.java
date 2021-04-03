package org.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ejb.Workout;

/**
 * Session Bean implementation class WorkoutEAOImpl
 */
@Stateless
public class WorkoutEAOImpl implements WorkoutEAOLocal {

	@PersistenceContext(unitName="AssignmentEJBSql")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public WorkoutEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Workout findByCode(String code) {
    	return em.find(Workout.class, code);
    }
    
    public Workout createWorkout (Workout workout) {
    	em.persist(workout);
    	return workout; 
    }
    
    public Workout updateWorkout (Workout workout) {
    	em.merge(workout);
    	return workout; 
    }
    
    public void deleteWorkout (String code) {
    	Workout workout = this.findByCode(code);
    	if(workout != null) {
    		em.remove(workout);
    	}
    }
    
    public List<Workout> findAll (){
    	TypedQuery<Workout> query = em.createNamedQuery("Workout.findAll", Workout.class); 
    	
    	List<Workout> result = query.getResultList(); 
    	return result;
    }
}
