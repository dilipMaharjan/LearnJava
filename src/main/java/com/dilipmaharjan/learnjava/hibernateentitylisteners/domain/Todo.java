package com.dilipmaharjan.learnjava.hibernateentitylisteners.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dilipmaharjan.learnjava.hibernateentitylisteners.listner.AuditListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditListener.class)
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	@CreationTimestamp
	@Column(nullable = false, updatable = false, insertable = true)
	private Date createdOn;

	@UpdateTimestamp
	@Column(nullable = false, updatable = true, insertable = true)
	private Date updatedOn;

}
