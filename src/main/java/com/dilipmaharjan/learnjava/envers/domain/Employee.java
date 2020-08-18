package com.dilipmaharjan.learnjava.envers.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Audited
@Data
@AuditTable("Employee_Hist")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	private String lastname;

	private String email;
}
