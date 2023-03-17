package it.epicode.be.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import it.epicode.be.security.encription.StringAttributeConverter;
import lombok.Data;

@Data
@Entity
@Component
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	private String nome;
	private String address;
	private String city;
	@OneToMany(mappedBy = "building")
	//@JsonIgnore Usare i DTO al posto di usare ignore
	private List<Postazione> postazioni;
	
	@Convert(converter=StringAttributeConverter.class)
	private String codiceAllarme;

}
