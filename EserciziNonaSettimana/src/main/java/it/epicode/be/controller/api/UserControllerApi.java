package it.epicode.be.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.dto.UserDTO;
import it.epicode.be.model.User;
import it.epicode.be.serviceinterface.AbstractUserService;

@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
	
	@Autowired
	AbstractUserService uss;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<UserDTO>> listaPrenotazioni() {
		List<User> user = uss.listaUser();
		List<UserDTO> useDto = user.stream().map(UserDTO::fromUser)
				.collect(Collectors.toList());
		return new ResponseEntity<>(useDto, HttpStatus.OK);
	}
	
//	@PostMapping
//	
//	@PutMapping
//	
//	@DeleteMapping
	
}
