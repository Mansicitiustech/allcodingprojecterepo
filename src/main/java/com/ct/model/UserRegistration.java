package com.ct.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="USER_REGISTRATION")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	private  long phNo;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
	@OneToOne
	@JoinColumn(name="uid",referencedColumnName="uid")
	private User user;
}
