package it.epicode.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Building;
import it.epicode.be.repository.BuildingRepository;
import it.epicode.be.serviceinterface.AbstractBuildingService;

@Service
public class BuildingService implements AbstractBuildingService {

	@Autowired
	BuildingRepository bur;
	@Value("${exception.entitynotfound}")
	String entitynotfound;

	@Override
	public Building insert(Building build) {
		return bur.save(build);
	}

	@Override
	public Building update(Building newBuilding) throws EntityNotFoundException {
		Optional<Building> oold = bur.findById(newBuilding.getId());
		if (oold.isEmpty()) {
			throw new EntityNotFoundException(entitynotfound, Building.class);
		}
//		Building old = oold.get();
//		old.setNome(newBuilding.getNome());
//		old.setAddress(newBuilding.getAddress());
//		old.setCity(newBuilding.getCity());
		return bur.save(newBuilding);
	}

	@Override
	public Optional<Building> findBuildingById(Long id) {
		return bur.findById(id);
	}

	@Override
	public List<Building> listaBuilding() {
		return bur.findAll();
	}

	@Override
	public void deleteBuilding(Long id) throws EntityNotFoundException {
		try {
			bur.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(entitynotfound, Building.class);
		}

	}
}
