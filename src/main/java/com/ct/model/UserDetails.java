package com.ct.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	private long phNo;
	private Date dob;
	private String gender;
	@OneToOne
	@JoinColumn(name="country",referencedColumnName="cid")
	private Country country;
	@OneToOne
	@JoinColumn(name="state",referencedColumnName="sid")
	private State state;
	@OneToOne
	@JoinColumn(name="city",referencedColumnName="ciid")
	private City city;
	private String password;
	private String status;
	
	
	
}
