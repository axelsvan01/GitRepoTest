package org.ejb;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="Workout.findAll", query="SELECT e FROM Workout e")})
@Table(name="Workout")
public class Workout implements Serializable {
	
	private String code; 
	private String location; 
	private Date date;
	
	private Set<Customer> particiapants; 
	
	@Id
	@Column(name="SessionCode")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="SessionLocation")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="SessionTimePass")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToMany(mappedBy="bookings", fetch= FetchType.EAGER)
	public Set<Customer> getParticiapants() {
		return particiapants;
	}
	public void setParticiapants(Set<Customer> particiapants) {
		this.particiapants = particiapants;
	} 	
}

