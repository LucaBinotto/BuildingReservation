package it.epicode.be.controller.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.dto.PostazioneDTO;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;
import it.epicode.be.serviceinterface.AbstractPostazioneService;

@RestController
@RequestMapping("/api/postazioni")
public class PostazioniControllerApi {
	@Autowired
	private AbstractPostazioneService pos;

	@GetMapping
	public ResponseEntity<Page<PostazioneDTO>> findByTypeAndBuildingCityFree(@RequestParam Type type,
			@RequestParam String city, @RequestParam int pageNum, @RequestParam int pageSize,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Optional<LocalDate> dateReservation) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<Postazione> pagPost = null;
		if (dateReservation.isEmpty()) {
			pagPost = pos.findByTypeAndBuildingCity(type, city, pageable);
		} else {
			pagPost = pos.findByTypeAndBuildingCityFree(city, type, dateReservation.get(), pageable);
		}
		Page<PostazioneDTO> pagPostDto = pagPost.map(PostazioneDTO::fromPostazione);
		return new ResponseEntity<>(pagPostDto, HttpStatus.OK);
	}

}
