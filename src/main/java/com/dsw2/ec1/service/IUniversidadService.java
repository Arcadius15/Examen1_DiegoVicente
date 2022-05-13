package com.dsw2.ec1.service;

import java.util.List;

import com.dsw2.ec1.dto.UniDTO;

public interface IUniversidadService {
	
	public void agregar(UniDTO univ);
	public void modificar(UniDTO univ);
	public void eliminar(int idUni);
	public List<UniDTO> listar();
	public UniDTO obtenerUniversidad(int idUni);

}
