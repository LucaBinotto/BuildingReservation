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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(List<Postazione> postazioni) {
		this.postazioni = postazioni;
	}

	public String getCodiceAllarme() {
		return codiceAllarme;
	}

	public void setCodiceAllarme(String codiceAllarme) {
		this.codiceAllarme = codiceAllarme;
	}

	
	
}
