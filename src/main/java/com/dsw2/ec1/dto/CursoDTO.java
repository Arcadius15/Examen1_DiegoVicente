package com.dsw2.ec1.dto;

import java.util.Set;


public class CursoDTO {
	
	private int idCurso;
	private String curso;
	private String descripcion;

	private MallaDTO malla;
	
	private Set<ProfeDTO> profesores;
	
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set<ProfeDTO> getProfesores() {
		return profesores;
	}
	public void setProfesores(Set<ProfeDTO> profesores) {
		this.profesores = profesores;
	}
	public MallaDTO getMalla() {
		return malla;
	}
	public void setMalla(MallaDTO malla) {
		this.malla = malla;
	}
	
	
	

}
