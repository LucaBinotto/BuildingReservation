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
}
