package it.epicode.be.model;

import java.util.List;

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
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String address;
	private String city;
	@OneToMany(mappedBy = "building")
	//@JsonIgnore Usare i DTO al posto di usare ignore
	private List<Postazione> postazioni;

}
