package it.epicode.be.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Postazione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long uniqueCode;
	private String description;
	public enum Tipo {PRIVATO, OPENSPACE, SALA_RIUNIONI}
	private Tipo type;
	private int maxCapacity;
	private Building building;
}
