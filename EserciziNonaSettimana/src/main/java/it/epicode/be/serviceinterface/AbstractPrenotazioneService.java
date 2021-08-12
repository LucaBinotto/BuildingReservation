package it.epicode.be.serviceinterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.be.controller.model.Regole;
import it.epicode.be.exception.BusinessLogicException;
import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Prenotazione;

public interface AbstractPrenotazioneService {
 
	List<Prenotazione> listaPrenotazioni();

	Optional<Prenotazione> findPrenotazioneById(Long id);

	Page<Prenotazione> listaPrenotazioniByUserId(Long userId, Pageable pageable);
	
	Prenotazione insertPrenotazione(Prenotazione pren) throws EntityNotFoundException, BusinessLogicException;

	Regole langRegola(String lang) throws BusinessLogicException;

	public void deletePrenotazione(Long id) throws EntityNotFoundException;

	Prenotazione updatePrenotazione(Prenotazione pre) throws EntityNotFoundException, BusinessLogicException ;
}