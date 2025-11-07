package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	private Integer account_no;
	private String ifsc;
	private String branch;
	private Double balance;
	@OneToOne
	private Customer customer;
}
