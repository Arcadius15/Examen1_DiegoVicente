package com.dsw2.ec1.service;

import java.util.List;

import com.dsw2.ec1.dto.ProfeDTO;

public interface IProfesorService {
	
	public void agregar(ProfeDTO profedto);
	public void modificar(ProfeDTO profedto);
	public void eliminar(int idProfe);
	public List<ProfeDTO> listar();
	public ProfeDTO obtenerProfesor(int idProfe);

}
