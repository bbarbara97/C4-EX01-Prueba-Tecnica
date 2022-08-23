package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Grupo;
import com.example.demo.service.GrupoServiceImpl;

@RestController
@RequestMapping("/api")
public class GrupoController {

	@Autowired
	GrupoServiceImpl grupoServiceImpl;
	
	//Mostrar que usuarios estan en que partidas
	@GetMapping("/grupo")
	public List<Grupo> listarGrupos(){
		return grupoServiceImpl.listarGrupos();
	}
	
	//añadir un usuario a una partida
	@PostMapping("/grupo")
	public Grupo salvarGrupo(@RequestBody Grupo grupo) {
		
		return grupoServiceImpl.guardarGrupo(grupo);
	}
	
	//Eliminacion del usuario a la partida
	@DeleteMapping("/grupo/{id}")
	public void eliminarGrupo(@PathVariable(name="id")int id) {
		grupoServiceImpl.eliminarGrupo(id);
	}
}
