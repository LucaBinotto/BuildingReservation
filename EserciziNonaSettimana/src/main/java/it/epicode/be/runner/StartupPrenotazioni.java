package it.epicode.be.runner;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.epicode.be.model.Building;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
import it.epicode.be.model.Postazione.Type;
import it.epicode.be.repository.BuildingRepository;
import it.epicode.be.repository.PostazioneRepository;
import it.epicode.be.repository.PrenotazioneRepository;
import it.epicode.be.repository.UserRepository;


@Component
public class StartupPrenotazioni implements CommandLineRunner{

	@Autowired
	private PostazioneRepository por;
	@Autowired
	private PrenotazioneRepository prr;
	@Autowired
	private UserRepository usr;
	@Autowired
	private BuildingRepository bur;
	
	Logger log = LoggerFactory.getLogger(StartupPrenotazioni.class);
	
	@Override
	public void run(String... args) throws Exception {

		log.info("Running");
		//popolazioneDatabase();
	}
	
	
	public void popolazioneDatabase() {
		
		log.info("Popolazione Database");
		
		Building build1 = new Building();
		build1.setAddress("Via buia, 18");
		build1.setCity("Amsterdam");
		build1.setNome("Vondel-Build");
		
		bur.save(build1);
		
		User usr1 = new User();
		usr1.setActive(true);
		usr1.setEmail("abc@fas.it");
		usr1.setName("Luca");
		usr1.setSurname("Binotto");
		usr1.setPassword("12345");
		usr1.setUsername("Elvandar");
		
		User usr2 = new User();
		usr2.setActive(true);
		usr2.setEmail("ddc@fass.it");
		usr2.setName("Paolo");
		usr2.setSurname("Bitta");
		usr2.setPassword("563424");
		usr2.setUsername("Pippo");
		  
		usr.save(usr1);
		usr.save(usr2);
		
		Postazione post1 = new Postazione();
		post1.setDescription("Comoda");
		post1.setMaxCapacity(15);
		post1.setType(Type.PRIVATO);
		post1.setBuilding(build1);
		
		Postazione post2 = new Postazione();
		post2.setDescription("Scomoda");
		post2.setMaxCapacity(2);
		post2.setType(Type.OPENSPACE);
		post2.setBuilding(build1);
		
		Postazione post3 = new Postazione();
		post3.setDescription("ENORME");
		post3.setMaxCapacity(260);
		post3.setType(Type.SALA_RIUNIONI);
		post3.setBuilding(build1);
		
		por.save(post1);
		por.save(post2);
		por.save(post3);
		
		Prenotazione pren1 = new Prenotazione();
		pren1.setDateReservation(LocalDate.of(2021, 9, 2));
		pren1.setPostazione(post1);
		pren1.setUser(usr1);
		
		Prenotazione pren2 = new Prenotazione();
		pren2.setDateReservation(LocalDate.of(2021, 9, 2));
		pren2.setPostazione(post2);
		pren2.setUser(usr2);
		
		Prenotazione pren3 = new Prenotazione();
		pren3.setDateReservation(LocalDate.of(2021, 10, 2));
		pren3.setPostazione(post3);
		pren3.setUser(usr1);
		
		prr.save(pren1);
		prr.save(pren2);
		prr.save(pren3);
		
		//Dare a mano i ruoli
		
//			ROLE_USER
//		    ROLE_ADMIN
		
		
	}

}
