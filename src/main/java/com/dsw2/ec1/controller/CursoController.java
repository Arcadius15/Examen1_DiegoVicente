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

import com.dsw2.ec1.dto.CursoDTO;
import com.dsw2.ec1.service.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private ICursoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<CursoDTO>> getCursos(){
		List<CursoDTO> lst = service.listar();
		return new ResponseEntity<List<CursoDTO>>(lst,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<CursoDTO> getCurso(@PathVariable Integer Id){
		CursoDTO dt = service.obtenerCurso(Id);
		if (dt!=null) {
			return new ResponseEntity<CursoDTO>(dt,HttpStatus.OK);
		}else {
			return new ResponseEntity<CursoDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Void> getCursos(@RequestBody CursoDTO cursodto){
		service.agregar(cursodto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> patchCurso(@RequestBody CursoDTO cursodto){
		CursoDTO cdt = service.obtenerCurso(cursodto.getIdCurso());
		if (cdt!=null) {
			service.modificar(cursodto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar/{Id}")
	public ResponseEntity<Void> deleteCurso(@PathVariable Integer Id){
		CursoDTO cdt = service.obtenerCurso(Id);
		if (cdt!=null) {
			service.eliminar(Id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
