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

import com.dsw2.ec1.dto.ProfeDTO;
import com.dsw2.ec1.service.IProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	private IProfesorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProfeDTO>> getUnis(){
		List<ProfeDTO> lst = service.listar();
		return new ResponseEntity<List<ProfeDTO>>(lst,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<ProfeDTO> getUni(@PathVariable Integer Id){
		ProfeDTO dt = service.obtenerProfesor(Id);
		if (dt!=null) {
			return new ResponseEntity<ProfeDTO>(dt,HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfeDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Void> postUni(@RequestBody ProfeDTO profedto){
		service.agregar(profedto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> patchUni(@RequestBody ProfeDTO profedto){
		ProfeDTO dt = service.obtenerProfesor(profedto.getIdProfesor());
		if (dt!=null) {
			service.modificar(profedto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar/{Id}")
	public ResponseEntity<Void> deleteUni(@PathVariable Integer Id){
		ProfeDTO dt = service.obtenerProfesor(Id);
		if (dt!=null) {
			service.eliminar(Id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
