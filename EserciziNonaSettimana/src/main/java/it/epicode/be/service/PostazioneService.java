package it.epicode.be.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;
import it.epicode.be.repository.PostazioneRepository;
import it.epicode.be.serviceinterface.AbstractPostazioneService;

@Service
public class PostazioneService implements AbstractPostazioneService {

	@Autowired
	private PostazioneRepository por;
	

	@Override
	public Page<Postazione> findByTypeAndBuildingCityFree(String city, Type type, LocalDate dateReservation,
			Pageable pageable) {
		return por.findByTypeAndBuildingCityFree(city, type,dateReservation, pageable);
	}
	
	@Override
	public Page<Postazione> findByTypeAndBuildingCity(Type type, String city, Pageable pageable){
		return por.findByTypeAndBuildingCity(type, city, pageable);
	}
	
}
