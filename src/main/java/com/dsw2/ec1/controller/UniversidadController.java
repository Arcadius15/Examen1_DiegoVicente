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

import com.dsw2.ec1.dto.UniDTO;
import com.dsw2.ec1.service.IUniversidadService;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {
	
	@Autowired
	private IUniversidadService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<UniDTO>> getUnis(){
		List<UniDTO> lst = service.listar();
		return new ResponseEntity<List<UniDTO>>(lst,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<UniDTO> getUni(@PathVariable Integer Id){
		UniDTO dt = service.obtenerUniversidad(Id);
		if (dt!=null) {
			return new ResponseEntity<UniDTO>(dt,HttpStatus.OK);
		}else {
			return new ResponseEntity<UniDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Void> postUni(@RequestBody UniDTO unidto){
		service.agregar(unidto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> patchUni(@RequestBody UniDTO unidto){
		UniDTO udt = service.obtenerUniversidad(unidto.getIdUniversidad());
		if (udt!=null) {
			service.modificar(unidto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar/{Id}")
	public ResponseEntity<Void> deleteUni(@PathVariable Integer Id){
		UniDTO udt = service.obtenerUniversidad(Id);
		if (udt!=null) {
			service.eliminar(Id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
