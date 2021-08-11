package it.epicode.be.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.exception.BusinessLogicException;
import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
import it.epicode.be.model.Postazione.Type;
import it.epicode.be.repository.PostazioneRepository;
import it.epicode.be.repository.PrenotazioneRepository;
import it.epicode.be.repository.UserRepository;
import it.epicode.be.serviceinterface.AbstractPrenotazioneService;

@Service
public class PrenotazioneService implements AbstractPrenotazioneService {

//	@Autowired
//	private BuildingRepository bur;
	@Autowired
	private PostazioneRepository por;
	@Autowired
	private PrenotazioneRepository prr;
	@Autowired
	private UserRepository usr;

	@Value("${exception.lessthantwodays}")
	String lessthantwodays;
	@Value("${exception.entitynotfound}")
	String entitynotfound;
	@Value("${exception.alreadyhavereservation}")
	String alreadyhavereservation;
	@Value("${exception.postazionealreadyreserved}")
	String postazionealreadyreserved;

	@Override
	public Page<Postazione> findByTypeAndBuildingCity(Type type, String city, Pageable pageable){
		return por.findByTypeAndBuildingCity(type, city, pageable);
	}
	
	@Override
	public List<Prenotazione> listaPrenotazioni() {
		return prr.findAll();
	}

	@Override
	public Optional<Prenotazione> findPrenotazioneById(Long id) {
		return prr.findById(id);
	}
	
	@Override
	public Prenotazione insertPrenotazione(Prenotazione pren) throws EntityNotFoundException, BusinessLogicException {
		if (diffInDaysIsLessThan(2, pren.getDateReservation(), pren.getDateReservationMade())) {
			throw new BusinessLogicException(lessthantwodays);
		}
		Optional<User> u = usr.findById(pren.getUser().getId());
		if (u.isEmpty())
			throw new EntityNotFoundException(entitynotfound, User.class);
		Optional<Postazione> p = por.findById(pren.getPostazione().getUniqueCode());
		if (p.isEmpty())
			throw new EntityNotFoundException(entitynotfound, Postazione.class);
//		Pageable pageable = PageRequest.of(0, 1);
//		Page<Prenotazione> paginaPren = prr.findByUserAndDate(u.get(), pren.getDateReservation(), pageable);
//		if (paginaPren.hasContent()) {
//			throw new BusinessLogicException(alreadyhavereservation);
//		}
		if(userHasReservationForDays(u.get(), pren.getDateReservation())) {
			throw new BusinessLogicException(alreadyhavereservation);
		}
		
//		Page<Prenotazione> paginaPren1 = prr.findByPostazioneAndDate(p.get(), pren.getDateReservation(), pageable);
//		if (paginaPren1.hasContent()) {
//			throw new BusinessLogicException(postazionealreadyreserved);
//		}
		if(isWorkspaceAvaiable(p.get(),pren.getDateReservation())) {
			throw new BusinessLogicException(postazionealreadyreserved);
		}
		
		return prr.save(pren);
	}

	@Override
	public boolean diffInDaysIsLessThan(int numDays, LocalDate firstDate, LocalDate secondDate) {
		LocalDate numDayBefore = secondDate.minusDays(numDays);
		return firstDate.isAfter(numDayBefore);
	}

	@Override
	public boolean isWorkspaceAvaiable(Postazione p, LocalDate date) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Prenotazione> paginaPren = prr.findByPostazioneAndDateReservation(p, date, pageable);
		return paginaPren.hasContent();
	}
	
	@Override
	public boolean userHasReservationForDays(User u, LocalDate date) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Prenotazione> paginaPren = prr.findByUserAndDateReservation(u, date, pageable);
		return paginaPren.hasContent();
	}
}
