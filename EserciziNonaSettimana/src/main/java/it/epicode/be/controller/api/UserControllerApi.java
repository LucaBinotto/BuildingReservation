package it.epicode.be.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.dto.UserDTO;
import it.epicode.be.model.User;
import it.epicode.be.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
	
	@Autowired
	UserService usr;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> listaPrenotazioni() {
		List<User> user = usr.listaUser();
		List<UserDTO> UseDto = user.stream().map(UserDTO::fromUser)
				.collect(Collectors.toList());
		return new ResponseEntity<>(UseDto, HttpStatus.OK);
	}
	
//	@PostMapping
//	
//	@PutMapping
//	
//	@DeleteMapping
	
}
