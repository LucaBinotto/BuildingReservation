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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Postazione getPostazione() {
		return postazione;
	}

	public void setPostazione(Postazione postazione) {
		this.postazione = postazione;
	}

	public LocalDate getDateReservationMade() {
		return dateReservationMade;
	}

	public void setDateReservationMade(LocalDate dateReservationMade) {
		this.dateReservationMade = dateReservationMade;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	
	
}
