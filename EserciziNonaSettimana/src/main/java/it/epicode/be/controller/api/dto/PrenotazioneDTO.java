package it.epicode.be.controller.api.dto;

import java.time.LocalDate;

import it.epicode.be.model.Building;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

//Serve a costruire dei Json personalizzati con i dati che ci interessano a partire da una classe java, e viceversa

public class PrenotazioneDTO {

	private Long id;
	private LocalDate dateReservationMade; // data in cui è stata fatta prenotazione
	private LocalDate dateReservation; // data in cui la postazione verrà utilizzata

	private Long idUser;
	private String usernameUser;
	private Long idPostazione;
	private String tipoPostazione;
	private Long idBuilding;
	private String buildingName;
	private String buildingCity;

	public static PrenotazioneDTO fromPrenotazione(Prenotazione p) {
		PrenotazioneDTO preD = new PrenotazioneDTO();
		preD.setId(p.getId());
		preD.setIdUser(p.getUser().getId());
		preD.setUsernameUser(p.getUser().getUsername());
		preD.setDateReservationMade(p.getDateReservationMade());
		preD.setDateReservation(p.getDateReservation());
		preD.setIdPostazione(p.getPostazione().getUniqueCode());
		preD.setTipoPostazione(p.getPostazione().getType().toString());
		preD.setIdBuilding(p.getPostazione().getBuilding().getId());
		preD.setBuildingName(p.getPostazione().getBuilding().getNome());
		preD.setBuildingCity(p.getPostazione().getBuilding().getCity());
		return preD;
	}

	public Prenotazione toPrenotazione() throws IllegalArgumentException{
		Prenotazione pr = new Prenotazione();
		pr.setId(id);
		if (dateReservationMade != null)
			pr.setDateReservationMade(dateReservationMade);
		pr.setDateReservation(dateReservation);
		User u = new User();
		u.setId(idUser);
		u.setUsername(usernameUser);
		Building b = new Building();
		b.setId(idBuilding);
		b.setNome(buildingName);
		b.setCity(buildingCity);
		Postazione po = new Postazione();
		po.setUniqueCode(idPostazione);
		try {
			po.setType(Type.valueOf(tipoPostazione));
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		po.setBuilding(b);

		pr.setUser(u);
		pr.setPostazione(po);
		return pr;
	}

}
