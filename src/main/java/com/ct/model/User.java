package com.ct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="USER_DETAILS")
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long uid;
	@Column(unique=true)
private String email;
private String password;
private String status;

}
