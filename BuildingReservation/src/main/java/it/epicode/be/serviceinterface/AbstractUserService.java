package it.epicode.be.serviceinterface;

import java.util.List;
import java.util.Optional;

import it.epicode.be.model.User;

public interface AbstractUserService {

	List<User> listaUser();

	Optional<User> userByUsername(String username);

	void save(User u);
}