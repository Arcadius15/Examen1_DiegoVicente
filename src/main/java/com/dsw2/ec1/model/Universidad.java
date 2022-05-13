package com.dsw2.ec1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "universidad")
public class Universidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7006256220260678990L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUniversidad;
	@Column
	private String universidad;
	public int getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public Universidad(int idUniversidad, String universidad) {
		this.idUniversidad = idUniversidad;
		this.universidad = universidad;
	}
	public Universidad() {
	}
	
	@OneToOne
	@JoinColumn(name = "id_malla",nullable = true,unique = true,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references malla(id_malla)"))
	private Malla malla;
	public Malla getMalla() {
		return malla;
	}
	public void setMalla(Malla malla) {
		this.malla = malla;
	}
	
	
	

}
