package com.dsw2.ec1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MallaDTO {

	private int idMalla;
	private int anio;
	
	@JsonIgnoreProperties(value = "malla")
	private UniDTO universidad;
	public int getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(int idMalla) {
		this.idMalla = idMalla;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public UniDTO getUniversidad() {
		return universidad;
	}
	public void setUniversidad(UniDTO universidad) {
		this.universidad = universidad;
	}
	
	
	
	
}
