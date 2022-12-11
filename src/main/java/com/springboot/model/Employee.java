package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Emp_Table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_Name",nullable = false)
	private String firstName;
	@Column(name="last_Name",nullable = false)
	private String lastName;
	@Column(name="Emp_email",nullable = false)
	private String email;
}
