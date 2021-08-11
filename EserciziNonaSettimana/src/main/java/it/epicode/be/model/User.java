package it.epicode.be.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	@Column(unique=true)
	private String username;
	private String name;
	private String surname;
	private String email;
	@OneToMany(mappedBy = "user")
	private List<Prenotazione> prenotazioni;
	
	
}
