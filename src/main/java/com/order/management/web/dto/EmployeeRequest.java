package com.order.management.web.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.order.management.util.Constants.Role;

public class EmployeeRequest implements Serializable {

	private static final long serialVersionUID = 4790254099338014262L;

	private String name;

	private String surname;
	
	private String nickName;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date registrationDate;

	private Role role;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", surname=" + surname + ", nickName=" + nickName
				+ ", registrationDate=" + registrationDate + ", role=" + role + "]";
	}

}
