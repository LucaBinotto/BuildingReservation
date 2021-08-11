package it.epicode.be.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingControllerApi {

	@Autowired
	BuildingService bus;
	
	
	
}
