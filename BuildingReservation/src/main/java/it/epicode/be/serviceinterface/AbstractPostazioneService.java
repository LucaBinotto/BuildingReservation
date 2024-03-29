package it.epicode.be.serviceinterface;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;

public interface AbstractPostazioneService {

	Page<Postazione> findByTypeAndBuildingCityFree(String city, Type type, LocalDate dateReservation, Pageable pageable);

	Page<Postazione> findByTypeAndBuildingCity(Type type, String city, Pageable pageable);
}