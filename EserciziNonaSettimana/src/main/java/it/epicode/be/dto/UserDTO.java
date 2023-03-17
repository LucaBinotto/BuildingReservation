package it.epicode.be.dto;

import it.epicode.be.model.User;
import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private String username;
	private String name;
	private String surname;
	private String email;
	
	public static UserDTO fromUser(User usr) {
		UserDTO usrDto = new UserDTO();
		usrDto.setId(usr.getId());
		usrDto.setUsername(usr.getUsername());
		usrDto.setName(usr.getName());
		usrDto.setSurname(usr.getSurname());
		usrDto.setEmail(usr.getEmail());
		return usrDto;
	}
	public User toUser() {
		User usr = new User();
		usr.setId(id);
		usr.setUsername(username);
		usr.setName(name);
		usr.setSurname(surname);
		usr.setEmail(email);
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
	
	
}
