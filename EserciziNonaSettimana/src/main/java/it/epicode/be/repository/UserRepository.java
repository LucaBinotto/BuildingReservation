package it.epicode.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

}
