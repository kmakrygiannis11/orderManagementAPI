package com.order.management.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.order.management.util.Constants;
import com.order.management.util.Constants.Role;

@Entity
@Table(name = Constants.ENTITY_TABLE_PREFIX + "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6601217390096612482L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "NICKNAME", unique = true)
	private String nickName;

	@Column(name = "REGISTRATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	public Employee() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", registrationDate="
				+ registrationDate + ", role=" + role + "]";
	}

}
