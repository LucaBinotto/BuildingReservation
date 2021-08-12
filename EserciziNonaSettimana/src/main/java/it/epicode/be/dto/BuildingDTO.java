package it.epicode.be.dto;

import it.epicode.be.model.Building;
import lombok.Data;
@Data
public class BuildingDTO {

	private Long id;
	private String nome;
	private String address;
	private String city;
	
	public static BuildingDTO fromBuilding(Building build) {
		BuildingDTO buildDto = new BuildingDTO();
		buildDto.setId(build.getId());
		buildDto.setNome(build.getNome());
		buildDto.setAddress(build.getAddress());
		buildDto.setCity(build.getCity());
		return buildDto;
	}
	
	public Building toBuilding() {
		Building build = new Building();
		build.setId(id);
		build.setNome(nome);
		build.setAddress(address);
		build.setCity(city);
		return build;
	}
}
