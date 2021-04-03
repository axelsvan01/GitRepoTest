package org.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="Customer.findAll", query="SELECT e FROM Customer e")}) //Går att fylla på med @NamedQuery inom @NamedQueries.
@Table(name="Customer")
public class Customer implements Serializable {
	
	private String name; 
	private String pnrId; 
	private long phoneNo; // datatyp??
	private String address;
	
	private Set<Workout> bookings; 
	
	@Column(name="CustomerName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	@Column(name="PnrID")
	public String getPnrId() {
		return pnrId;
	}
	public void setPnrId(String pnrId) {
		this.pnrId = pnrId;
	}
	
	@Column(name="CustomerPhoneNr")
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@Column(name="CustomerAddress")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="WorkoutBookings", joinColumns = @JoinColumn(name="PnrID", referencedColumnName = "PnrID"), 
	inverseJoinColumns = @JoinColumn(name="SessionCode", referencedColumnName = "SessionCode"))
	public Set<Workout> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Workout> bookings) {
		this.bookings = bookings;
	} 	
	
}

