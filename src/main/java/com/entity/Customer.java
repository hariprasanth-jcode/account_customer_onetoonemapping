package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

	
	private String email;
	private String name;
	@Id
	private long phone;
}
