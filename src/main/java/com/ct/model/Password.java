package com.ct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER_PASSWORD")
@Data
public class Password {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long pid;
	private String password;
	@ManyToOne
	@JoinColumn(name="uid",referencedColumnName="uid")
	private User user;
}
