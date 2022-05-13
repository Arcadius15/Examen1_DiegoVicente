package com.dsw2.ec1.service;

import java.util.List;

import com.dsw2.ec1.dto.MallaDTO;

public interface IMallaService {
	
	public void agregar(MallaDTO malladto);
	public void modificar(MallaDTO malladto);
	public void eliminar(int idMalla);
	public List<MallaDTO> listar();
	public MallaDTO obtenerMalla(int idMalla);

}
