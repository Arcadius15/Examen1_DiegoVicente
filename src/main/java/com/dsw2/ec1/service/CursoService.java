package com.dsw2.ec1.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw2.ec1.dto.CursoDTO;
import com.dsw2.ec1.model.Curso;
import com.dsw2.ec1.repository.CursoRepository;
import com.dsw2.ec1.repository.MallaRepository;

@Service
public class CursoService implements ICursoService{
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private MallaRepository mrepository;

	@Override
	public void agregar(CursoDTO cursodto) {
		Curso c = new Curso();
		c.setCurso(cursodto.getCurso());
		c.setDescripcion(cursodto.getDescripcion());
		c.setMalla(mrepository.getById(cursodto.getMalla().getIdMalla()));
		repository.save(c);
	}

	@Override
	public void modificar(CursoDTO cursodto) {
		Curso c = new Curso();
		c.setIdCurso(cursodto.getIdCurso());
		c.setCurso(cursodto.getCurso());
		c.setDescripcion(cursodto.getDescripcion());
		c.setMalla(mrepository.getById(cursodto.getMalla().getIdMalla()));
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminar(int idCursodto) {
		repository.deleteById(idCursodto);
	}

	@Override
	public List<CursoDTO> listar() {
		List<CursoDTO> lstDTO = new ArrayList<>();
		List<Curso> lstCursos = repository.findAll();
		ModelMapper mp = new ModelMapper();
		for (Curso curso : lstCursos) {
			CursoDTO dt =  new CursoDTO();
			dt = mp.map(curso, CursoDTO.class);
			lstDTO.add(dt);
		}
		return lstDTO;
	}

	@Override
	public CursoDTO obtenerCurso(int idCursodto) {
		Curso c = repository.getById(idCursodto);
		ModelMapper mp = new ModelMapper();
		CursoDTO dt = mp.map(c, CursoDTO.class);
		return dt;
	}
	
	

}
