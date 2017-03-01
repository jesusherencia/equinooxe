package com.equinooxe.module.user;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.equinooxe.domain.AgentUser;
import com.equinooxe.domain.Authority;
import com.equinooxe.domain.User;

public class AgentUserForm {

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

	private String[] autorities = new String[99];

	private Set<Authority> availableAutorities = new HashSet<>();


	public AgentUserForm() {
		autorities = new String[99];
		availableAutorities = new HashSet<>();
	}

	public AgentUserForm(Set<Authority> avelaibleAutorities) {
		autorities = new String[99];
		avelaibleAutorities = new HashSet<>();
	}

	public AgentUserForm(AgentUser au, Set<Authority> avelaibleAutorities) {
		this.initUserCommonPart(au, avelaibleAutorities);
	}

	private void initUserCommonPart(User u, Set<Authority> availableAutorities) {
		this.email = u.getEmail();
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
		this.login = u.getLogin();
		this.id = u.getId();
		int i = 0;
		for (Authority autho : u.getAuthorities()) {
			this.autorities[i] = autho.getName();
			i++;
		}
		this.availableAutorities= availableAutorities;
	}

	public String[] getAutorities() {
		return autorities;
	}

	public void setAutorities(String[] autorities) {
		this.autorities = autorities;
	}

	public Set<Authority> getAvailableAutorities() {
		return availableAutorities;
	}

	public void setAvailableAutorities(Set<Authority> avelaibleAutorities) {
		this.availableAutorities = avelaibleAutorities;
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
