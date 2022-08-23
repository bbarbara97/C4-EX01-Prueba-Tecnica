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

import com.example.demo.dto.Juego;
import com.example.demo.service.JuegoServiceImpl;

@RestController
@RequestMapping("/api")
public class JuegoController {

	@Autowired
	JuegoServiceImpl juegoServiceImpl;
	
	//Se pueden visualizar todos los juegos creados para poder añadirlo a la partida
	@GetMapping("/juego")
	public List<Juego> listarJuego(){
		return juegoServiceImpl.listarJuego();
	}
	
	//Se añade un juego
	@PostMapping("/juego")
	public Juego salvarJuego(@RequestBody Juego juego) {
		
		return juegoServiceImpl.guardarJuego(juego);
	}
	
	//guardamos el juego por id para utilizarlo en algun momento
	@GetMapping("/juego/{id}")
	public Juego JuegoXID(@PathVariable(name="id") int id) {	
		return juegoServiceImpl.juegoXID(id);
	}
	
	//Eliminacion de juegos
	@DeleteMapping("/juego/{id}")
	public void eleiminarJuego(@PathVariable(name="id")int id) {
		juegoServiceImpl.eliminarJuego(id);
	}
}
