package it.epicode.be.serviceinterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.be.exception.BusinessLogicException;
import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
import it.epicode.be.model.Postazione.Type;

public interface AbstractPrenotazioneService {

	Page<Postazione> findByTypeAndBuildingCity(Type type, String city, Pageable pageable);

	List<Prenotazione> listaPrenotazioni();

	Optional<Prenotazione> findPrenotazioneById(Long id);

	Prenotazione insertPrenotazione(Prenotazione pren) throws EntityNotFoundException, BusinessLogicException;

	boolean diffInDaysIsLessThan(int numDays, LocalDate firstDate, LocalDate secondDate);

	boolean isWorkspaceAvaiable(Postazione p, LocalDate date);

	boolean userHasReservationForDays(User u, LocalDate date);

}