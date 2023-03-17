package it.epicode.be.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

	Page<User> findByName(String name, Pageable pageable);
	
	Page<User> findByNameAndSurname(String name,String surname, Pageable pageable);
	
	Optional<User> findByUsername(String username);
}
