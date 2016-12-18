package com.equinooxe.module.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.equinooxe.domain.User;

public class UserForm {
	
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String login;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

	@Email
	private String email;
	
	private String password;
	
	public UserForm(){
		
	}
	
	public UserForm(User u){
		this.email=u.getEmail();
		this.firstName= u.getFirstName();
		this.lastName= u.getLastName();
		this.login= u.getLogin();
		this.id=u.getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
