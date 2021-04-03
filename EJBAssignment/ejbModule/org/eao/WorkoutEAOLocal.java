package org.eao;

import java.util.List;

import javax.ejb.Local;

import org.ejb.Workout;

@Local
public interface WorkoutEAOLocal {

	public Workout findByCode(String code);
	public Workout createWorkout (Workout workout);
	public Workout updateWorkout (Workout workout); 
	public void deleteWorkout (String code); 
	public List<Workout> findAll (); 
}
