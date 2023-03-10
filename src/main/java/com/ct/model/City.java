package com.ct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ciid;
	private String name;
	//@OneToOne
	@ManyToOne
	@JoinColumn(name="sid",referencedColumnName="sid")
	private State state;
}
