package com.ct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int cid;
private String name;
}
