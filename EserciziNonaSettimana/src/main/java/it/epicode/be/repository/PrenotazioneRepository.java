package it.epicode.be.repository;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
@Repository
public interface PrenotazioneRepository  extends JpaRepository<Prenotazione,Long> {

	public Page<Prenotazione> findByUserAndDateReservation(User u, LocalDate date, Pageable pageable);
	
	public Page<Prenotazione> findByPostazioneAndDateReservation(Postazione p, LocalDate dateReservation, Pageable pageable);
}
