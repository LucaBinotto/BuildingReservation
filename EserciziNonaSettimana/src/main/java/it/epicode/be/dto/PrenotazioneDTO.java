package it.epicode.be.dto;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateReservationMade() {
		return dateReservationMade;
	}

	public void setDateReservationMade(LocalDate dateReservationMade) {
		this.dateReservationMade = dateReservationMade;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsernameUser() {
		return usernameUser;
	}

	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}

	public Long getIdPostazione() {
		return idPostazione;
	}

	public void setIdPostazione(Long idPostazione) {
		this.idPostazione = idPostazione;
	}

	public String getTipoPostazione() {
		return tipoPostazione;
	}

	public void setTipoPostazione(String tipoPostazione) {
		this.tipoPostazione = tipoPostazione;
	}

	public Long getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(Long idBuilding) {
		this.idBuilding = idBuilding;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingCity() {
		return buildingCity;
	}

	public void setBuildingCity(String buildingCity) {
		this.buildingCity = buildingCity;
	}

}
