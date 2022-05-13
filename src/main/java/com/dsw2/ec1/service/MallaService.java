package com.dsw2.ec1.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw2.ec1.dto.MallaDTO;
import com.dsw2.ec1.model.Malla;
import com.dsw2.ec1.repository.MallaRepository;

@Service
public class MallaService implements IMallaService{
	
	@Autowired
	private MallaRepository repository;

	@Override
	public void agregar(MallaDTO malladto) {
		Malla m = new Malla();
		//BeanUtils.copyProperties(malladto, m);
		ModelMapper mp = new ModelMapper();
		m = mp.map(malladto, Malla.class);
		System.out.println(m.getUniversidad().getIdUniversidad());
		repository.save(m);
	}

	@Override
	public void modificar(MallaDTO malladto) {
		Malla m = new Malla();
		BeanUtils.copyProperties(malladto, m);
		repository.saveAndFlush(m);
		
	}

	@Override
	public void eliminar(int idMalla) {
		repository.deleteById(idMalla);
		
	}

	@Override
	public List<MallaDTO> listar() {
		List<MallaDTO> lst = new ArrayList<MallaDTO>();
		List<Malla> lstm = repository.findAll();
		for (Malla malla : lstm) {
			MallaDTO m = new MallaDTO();
			BeanUtils.copyProperties(malla, m);
			lst.add(m);
		}
		return lst;
	}

	@Override
	public MallaDTO obtenerMalla(int idMalla) {
		Malla m =  repository.findById(idMalla).orElse(null);
		MallaDTO dt = new MallaDTO();
		BeanUtils.copyProperties(m, dt);
		return dt;
	}

}
