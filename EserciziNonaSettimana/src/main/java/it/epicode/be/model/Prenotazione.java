package it.epicode.be.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Prenotazione {

	private User user;
	private Postazione postazione;
	private LocalDate date;
	
}
