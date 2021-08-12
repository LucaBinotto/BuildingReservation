package it.epicode.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.User;
import it.epicode.be.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository usr;

	public List<User> listaUser() {
		return usr.findAll();
	}
	
	
}
