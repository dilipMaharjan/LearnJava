package com.dilipmaharjan.learnjava.hibernateinterceptor.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@DateTimeFormat(pattern = "mm/dd/yy hh:mm")
	@Column(nullable = false, updatable = false, insertable = true)
	private Date createAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@DateTimeFormat(pattern = "mm/dd/yy hh:mm")
	@Column(nullable = false, updatable = true, insertable = true)
	private Date updatedAt;
}
