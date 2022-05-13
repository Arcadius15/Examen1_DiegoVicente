package com.dsw2.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsw2.ec1.dto.MallaDTO;
import com.dsw2.ec1.service.IMallaService;

@RestController
@RequestMapping("/malla")
public class MallaController {

	@Autowired
	private IMallaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<MallaDTO>> getMallas(){
		List<MallaDTO> lst = service.listar();
		return new ResponseEntity<List<MallaDTO>>(lst,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<MallaDTO> getMalla(@PathVariable Integer Id){
		MallaDTO dt = service.obtenerMalla(Id);
		if (dt!=null) {
			return new ResponseEntity<MallaDTO>(dt,HttpStatus.OK);
		}else {
			return new ResponseEntity<MallaDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Void> postMalla(@RequestBody MallaDTO malladto){

		service.agregar(malladto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> patchMalla(@RequestBody MallaDTO cursodto){
		MallaDTO dt = service.obtenerMalla(cursodto.getIdMalla());
		if (dt!=null) {
			service.modificar(cursodto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar/{Id}")
	public ResponseEntity<Void> deleteMalla(@PathVariable Integer Id){
		MallaDTO dt = service.obtenerMalla(Id);
		if (dt!=null) {
			service.eliminar(Id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
