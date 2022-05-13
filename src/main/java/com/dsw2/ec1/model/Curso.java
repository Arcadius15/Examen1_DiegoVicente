package com.dsw2.ec1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3574484527913646130L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String curso;
	private String descripcion;
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
	public Curso(int idCurso, String curso, String descripcion) {
		this.idCurso = idCurso;
		this.curso = curso;
		this.descripcion = descripcion;
	}
	public Curso() {
	}
	
	@ManyToOne
	@JoinColumn(name="id_malla",nullable = false,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references malla(id_malla)"))
	private Malla malla;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "cursos_profesores", 
		joinColumns = @JoinColumn(name ="id_curso",nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references curso(id_curso)")),
		inverseJoinColumns = @JoinColumn(name = "id_profesor",nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesor(id_profesor)"))
			)
	private Set<Profesor> profesores =  new HashSet<>();
	public Malla getMalla() {
		return malla;
	}
	public void setMalla(Malla malla) {
		this.malla = malla;
	}
	public Set<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	

}
