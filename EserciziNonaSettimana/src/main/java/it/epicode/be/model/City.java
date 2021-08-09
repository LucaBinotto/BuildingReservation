package it.epicode.be.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nome;
}
