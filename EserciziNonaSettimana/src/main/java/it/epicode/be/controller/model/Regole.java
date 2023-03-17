package it.epicode.be.controller.model;

import lombok.Data;

@Data
public class Regole {
	
	private String testo;

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	
}
