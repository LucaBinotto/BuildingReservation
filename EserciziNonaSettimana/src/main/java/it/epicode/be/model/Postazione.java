package it.epicode.be.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Postazione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long uniqueCode;
	private String description;
	public enum Type {PRIVATO, OPENSPACE, SALA_RIUNIONI}
	@Enumerated(EnumType.STRING)
	private Type type;
	private int maxCapacity;
	@ManyToOne
	@JoinColumn(name="building_id") //serve per rinominare la colonna foreign key
	private Building building;
}
