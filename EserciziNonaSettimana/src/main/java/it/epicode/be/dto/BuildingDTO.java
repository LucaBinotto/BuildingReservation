package it.epicode.be.dto;

import it.epicode.be.model.Building;
import lombok.Data;
@Data
public class BuildingDTO {

	private Long id;
	private String nome;
	private String address;
	private String city;
	private String codiceAllarme;
	
	public static BuildingDTO fromBuilding(Building build) {
		BuildingDTO buildDto = new BuildingDTO();
		buildDto.setId(build.getId());
		buildDto.setNome(build.getNome());
		buildDto.setAddress(build.getAddress());
		buildDto.setCity(build.getCity());
		buildDto.setCodiceAllarme(build.getCodiceAllarme());
		return buildDto;
	}
	
	public Building toBuilding() {
		Building build = new Building();
		build.setId(id);
		build.setNome(nome);
		build.setAddress(address);
		build.setCity(city);
		build.setCodiceAllarme(codiceAllarme);
		return build;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCodiceAllarme() {
		return codiceAllarme;
	}

	public void setCodiceAllarme(String codiceAllarme) {
		this.codiceAllarme = codiceAllarme;
	}
	
	
	
}
