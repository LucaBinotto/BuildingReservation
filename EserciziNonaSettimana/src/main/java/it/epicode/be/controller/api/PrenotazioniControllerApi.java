package it.epicode.be.controller.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.controller.model.Regole;
import it.epicode.be.dto.PrenotazioneDTO;
import it.epicode.be.exception.BusinessLogicException;
import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
import it.epicode.be.serviceinterface.AbstractPrenotazioneService;
import it.epicode.be.serviceinterface.AbstractUserService;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioniControllerApi {
	static final Logger log = LoggerFactory.getLogger(PrenotazioniControllerApi.class);

	@Autowired
	private AbstractPrenotazioneService prs;
	@Autowired
	AbstractUserService uss;
	
	@GetMapping("/info")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<String> info(@RequestParam String lang) { // @PathVariable
		Regole reg;
		try {
			reg = prs.langRegola(lang);
			return new ResponseEntity<>(reg.getTesto(), HttpStatus.OK);
		} catch (BusinessLogicException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getPrenotazioneById(@PathVariable Long id) {
		Optional<Prenotazione> cercata = prs.findPrenotazioneById(id);
		if (cercata.isEmpty()) {
			return new ResponseEntity<>("Prenotazione non trovata", HttpStatus.NOT_FOUND);
		}
		PrenotazioneDTO cerDto = PrenotazioneDTO.fromPrenotazione(cercata.get());
		return new ResponseEntity<>(cerDto, HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<List<PrenotazioneDTO>> listaPrenotazioni() {
		List<Prenotazione> prenotazioni = prs.listaPrenotazioni();
		List<PrenotazioneDTO> prenotazioniDto = prenotazioni.stream().map(PrenotazioneDTO::fromPrenotazione)
				.collect(Collectors.toList());
		return new ResponseEntity<>(prenotazioniDto, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> insertPrenotazione(@RequestBody PrenotazioneDTO prenDto) {

		if (prenDto.getDateReservationMade() == null || prenDto.getDateReservationMade().equals(LocalDate.now())) {
			try {
				Prenotazione pren = prenDto.toPrenotazione();
				Prenotazione inserted = prs.insertPrenotazione(pren);
				return new ResponseEntity<>(PrenotazioneDTO.fromPrenotazione(inserted), HttpStatus.CREATED);
			} catch (EntityNotFoundException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			} catch (BusinessLogicException | IllegalArgumentException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Non è possibile cambiare la data di effetuazione della prenotazione",
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deletePrenotazione(@PathVariable Long id) {
		try {
			prs.deletePrenotazione(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updatePrenotazione(@PathVariable Long id , @RequestBody PrenotazioneDTO preDto){
		if(!id.equals(preDto.getId())) {
			return new ResponseEntity<>("L'id non corrisponde", HttpStatus.BAD_REQUEST);
		}
		Prenotazione pre = preDto.toPrenotazione();
		try {
			Prenotazione updated = prs.updatePrenotazione(pre);
			return new ResponseEntity<>(PrenotazioneDTO.fromPrenotazione(updated),HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		} catch (BusinessLogicException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mie")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getPrenotazioniByLoggedUser(@RequestParam int pageNum, @RequestParam int pageSize) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		Optional<User> trovato = uss.userByUsername(username);
		if (trovato.isEmpty()) {
			return new ResponseEntity<>("Utente non trovato", HttpStatus.NOT_FOUND);
		}
		Long userId = trovato.get().getId();
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<PrenotazioneDTO> prenDto = prs.listaPrenotazioniByUserId(userId, pageable).map(PrenotazioneDTO::fromPrenotazione);
		
		return new ResponseEntity<>(prenDto, HttpStatus.OK);
	}
}
