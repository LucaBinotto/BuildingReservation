package it.epicode.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionePrenotazioniController {
	
	@Autowired
	ApplicationContext con;
	
	@GetMapping("/")
	public String home() {
		return"home";
	}
	
}
