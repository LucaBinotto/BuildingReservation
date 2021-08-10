package it.epicode.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.model.Prenotazione;

public interface PrenotazioneRepository  extends JpaRepository<Prenotazione,Long> {

	
}
