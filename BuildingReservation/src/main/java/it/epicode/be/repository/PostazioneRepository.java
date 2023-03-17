package it.epicode.be.repository;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;
@Repository
public interface PostazioneRepository  extends JpaRepository<Postazione,Long>{

	public Page<Postazione> findByTypeAndBuildingCity(Type type, String city, Pageable pageable);
	
	@Query("SELECT post FROM Postazione post WHERE post.building.city = :city AND post.type = :type "
			+ "AND post.id NOT IN (SELECT pre.postazione.id FROM Prenotazione pre WHERE pre.dateReservation = :dateReservation)")
	public Page<Postazione> findByTypeAndBuildingCityFree(String city, Type type, LocalDate dateReservation, Pageable pageable);
}
