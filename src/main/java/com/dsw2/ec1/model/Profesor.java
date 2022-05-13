package com.dsw2.ec1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1750150042157154374L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProfesor;
	@Column
	private String profesor;
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
	public Profesor(int idProfesor, String profesor) {
		this.idProfesor = idProfesor;
		this.profesor = profesor;
	}
	public Profesor() {
	}
	
	@ManyToMany(mappedBy = "profesores",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Curso> cursos = new HashSet<>();
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
