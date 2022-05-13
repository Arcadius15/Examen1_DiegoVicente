package com.dsw2.ec1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "malla")
public class Malla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7242032537389747253L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMalla;
	@Column
	private int anio;
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
	public Malla(int idMalla, int anio) {
		this.idMalla = idMalla;
		this.anio = anio;
	}
	public Malla() {
	}
	
	@OneToOne(mappedBy = "malla")
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla")
	private Collection<Curso> cursos = new ArrayList<Curso>();
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public Collection<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}
	
	

}
