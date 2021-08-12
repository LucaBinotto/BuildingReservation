package it.epicode.be.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.dto.BuildingDTO;
import it.epicode.be.exception.EntityNotFoundException;
import it.epicode.be.model.Building;
import it.epicode.be.serviceinterface.AbstractBuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingControllerApi {

	@Autowired
	AbstractBuildingService bus;
	
	@PostMapping
	public ResponseEntity<BuildingDTO> insert(@RequestBody BuildingDTO buildDto) {
		Building build = buildDto.toBuilding();
		Building inserted = bus.insert(build);
		return new ResponseEntity<>(BuildingDTO.fromBuilding(inserted),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BuildingDTO buildDto) {
		if(id.equals(buildDto.getId())) {
			return new ResponseEntity<>("L'id non corrisponde",HttpStatus.BAD_REQUEST);
		}
		Building build = buildDto.toBuilding();
		Building updated;
		try {
			updated = bus.update(build);
			return new ResponseEntity<>(BuildingDTO.fromBuilding(updated),HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<BuildingDTO>> listaBuilding() {
		List<Building> prenotazioni = bus.listaBuilding();
		List<BuildingDTO> prenotazioniDto = prenotazioni.stream().map(BuildingDTO::fromBuilding)
				.collect(Collectors.toList());
		return new ResponseEntity<>(prenotazioniDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBuilding(@PathVariable Long id) {
		try {
			bus.deleteBuilding(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
