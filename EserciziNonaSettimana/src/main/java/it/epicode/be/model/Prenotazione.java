package it.epicode.be.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	@ManyToOne
	private User user;
	@ManyToOne 
	private Postazione postazione;
	private LocalDate dateReservationMade; //data in cui è stata fatta prenotazione
	private LocalDate dateReservation; //data in cui la postazione verrà utilizzata

	public Prenotazione() {
		dateReservationMade = LocalDate.now();
	}
	
}
