package com.huertafc.user.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public User(final String firstName, final String lastName, final String email, final Long departmentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentId = departmentId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private Long departmentId;
}
