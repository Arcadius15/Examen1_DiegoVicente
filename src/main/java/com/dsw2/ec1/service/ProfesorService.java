package com.dsw2.ec1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw2.ec1.dto.ProfeDTO;
import com.dsw2.ec1.model.Profesor;
import com.dsw2.ec1.repository.ProfesorRepository;

@Service
public class ProfesorService implements IProfesorService{
	
	@Autowired
	private ProfesorRepository repository;

	@Override
	public void agregar(ProfeDTO profedto) {
		Profesor p = new Profesor();
		BeanUtils.copyProperties(profedto, p);
		repository.save(p);
	}

	@Override
	public void modificar(ProfeDTO profedto) {
		Profesor p = new Profesor();
		BeanUtils.copyProperties(profedto, p);
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminar(int idProfe) {
		repository.deleteById(idProfe);
		
	}

	@Override
	public List<ProfeDTO> listar() {
		List<ProfeDTO> lst =  new ArrayList<ProfeDTO>();
		List<Profesor> lstp = repository.findAll();
		for (Profesor profesor : lstp) {
			ProfeDTO dt = new ProfeDTO();
			BeanUtils.copyProperties(profesor, dt);
			lst.add(dt);
		}
		return lst;
	}

	@Override
	public ProfeDTO obtenerProfesor(int idProfe) {
		Profesor p = repository.findById(idProfe).orElse(null);
		ProfeDTO dt = new ProfeDTO();
		BeanUtils.copyProperties(p, dt);
		return dt;
	}

}
