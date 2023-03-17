package it.epicode.be.serviceinterface;

import java.util.List;
import java.util.Optional;

import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Building;

public interface AbstractBuildingService {

	Building insert(Building build);

	Building update(Building newBuilding) throws EntityNotFoundException;

	Optional<Building> findBuildingById(Long id);

	List<Building> listaBuilding();

	void deleteBuilding(Long id) throws EntityNotFoundException;

}