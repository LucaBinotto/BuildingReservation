package it.epicode.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.repository.BuildingRepository;

@Service
public class BuildingService {
	
	@Autowired
	BuildingRepository bur;
	
}
