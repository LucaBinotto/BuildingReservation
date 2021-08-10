package it.epicode.be.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.model.User;
@Configuration
public class UserConfig {

	@Bean
	public User utente1() {
		User utente = new User();
		utente.setEmail("abc@tre.it");
		utente.setName("ciccio");
		utente.setSurname("pasticcio");
		return utente;
	}
	
	}
