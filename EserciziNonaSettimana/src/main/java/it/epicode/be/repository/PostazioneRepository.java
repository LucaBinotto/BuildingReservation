package it.epicode.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;

public interface PostazioneRepository  extends JpaRepository<Postazione,Long>{

	public List<Postazione> findByTypeAndBuildingCity(Type type, String city);
	
}
