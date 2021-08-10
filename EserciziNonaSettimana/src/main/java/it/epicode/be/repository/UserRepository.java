package it.epicode.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.model.User;

public interface UserRepository  extends JpaRepository<User,Long>{

}
