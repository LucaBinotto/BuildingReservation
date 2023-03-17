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
}
