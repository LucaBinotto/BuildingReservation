package it.epicode.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.User;
import it.epicode.be.repository.UserRepository;
import it.epicode.be.serviceinterface.AbstractUserService;

@Service
public class UserService implements AbstractUserService {
	
	@Autowired
	private UserRepository usr;

	@Override
	public List<User> listaUser() {
		return usr.findAll();
	}
	
	@Override
	public Optional<User> userByUsername(String username){
		return usr.findByUsername(username);
	}
	
}
