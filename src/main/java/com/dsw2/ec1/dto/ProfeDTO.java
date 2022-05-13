package com.dsw2.ec1.dto;

import java.util.Set;

public class ProfeDTO {

	private int idProfesor;
	private String profesor;
	private Set<CursoDTO> cursos;
	
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Set<CursoDTO> getCursos() {
		return cursos;
	}
	public void setCursos(Set<CursoDTO> cursos) {
		this.cursos = cursos;
	}
	
	
}
