package com.dsw2.ec1.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw2.ec1.dto.UniDTO;
import com.dsw2.ec1.model.Universidad;
import com.dsw2.ec1.repository.UniversidadRepository;

@Service
public class UniversidadService implements IUniversidadService{
	
	@Autowired
	private UniversidadRepository repository;

	@Override
	public void agregar(UniDTO univ) {
		Universidad u =  new Universidad();
		BeanUtils.copyProperties(univ, u,"malla");
		repository.save(u);
	}

	@Override
	public void modificar(UniDTO univ) {
		ModelMapper mp =  new ModelMapper();
		Universidad u = mp.map(univ, Universidad.class);
		repository.saveAndFlush(u);
		
	}

	@Override
	public void eliminar(int idUni) {
		repository.deleteById(idUni);
	}

	@Override
	public List<UniDTO> listar() {
		List<UniDTO> lstDTO = new ArrayList<>();
		List<Universidad> lstUni = repository.findAll();
		for (Universidad universidad : lstUni) {
			UniDTO dt = new UniDTO();
			BeanUtils.copyProperties(universidad, dt);
			lstDTO.add(dt);
		}
		return lstDTO;
	}

	@Override
	public UniDTO obtenerUniversidad(int idUni) {
		Universidad u = repository.findById(idUni).orElse(null);
		UniDTO dt = new UniDTO();
		BeanUtils.copyProperties(u, dt);
		return dt;
	}

}
