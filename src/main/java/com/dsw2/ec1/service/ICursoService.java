package com.dsw2.ec1.service;

import java.util.List;

import com.dsw2.ec1.dto.CursoDTO;

public interface ICursoService {
	
	public void agregar(CursoDTO cursodto);
	public void modificar(CursoDTO cursodto);
	public void eliminar(int idCursodto);
	public List<CursoDTO> listar();
	public CursoDTO obtenerCurso(int idCursodto);
	

}
