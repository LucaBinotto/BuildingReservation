package it.epicode.be.dto;

import it.epicode.be.model.User;
import lombok.Data;
@Data
public class UserRegisterDTO {


	private Long id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	
	public User toUser() {
		User usr = new User();
		
		usr.setUsername(username);
		usr.setName(name);
		usr.setSurname(surname);
		usr.setEmail(email);
		usr.setPassword(password);
		return usr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	
}
