package it.epicode.be.controller.api.dto;

import it.epicode.be.model.Building;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Postazione.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostazioneDTO {
	
	private Long uniqueCode;
	private String description;
	private Type type;
	private int maxCapacity;
	private Long buildingId;
	private String buildingName;
	private String buildingCity;
	
	
	
	public static PostazioneDTO fromPostazione(Postazione p) {
		PostazioneDTO pDto = new PostazioneDTO();
		pDto.setUniqueCode(p.getUniqueCode());
		pDto.setDescription(p.getDescription());
		pDto.setType(p.getType());
		pDto.setMaxCapacity(p.getMaxCapacity());
		pDto.setBuildingId(p.getBuilding().getId());
		pDto.setBuildingName(p.getBuilding().getNome());
		pDto.setBuildingCity(p.getBuilding().getCity());
		return pDto;
	}
	
	public Postazione toPostazione() {
		Postazione p = new Postazione();
		p.setUniqueCode(uniqueCode);
		p.setDescription(description);
		p.setType(type);
		p.setMaxCapacity(maxCapacity);
		Building b = new Building();
		b.setId(buildingId);
		b.setNome(buildingName);
		b.setCity(buildingCity);
		p.setBuilding(b);
		return p;
	}
	
	
}
