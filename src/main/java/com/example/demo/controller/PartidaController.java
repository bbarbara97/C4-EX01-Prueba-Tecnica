package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Partida;
import com.example.demo.service.PartidaServiceImpl;

@RestController
@RequestMapping("/api")
public class PartidaController {

	@Autowired
	PartidaServiceImpl partidaServiceImpl;
	
	//Se ven todas las partidas disponibles
	@GetMapping("/partida")
	public List<Partida> listarPartida(){
		return partidaServiceImpl.listarPartida();
	}
	
	//Creacion de una partida
	@PostMapping("/partida")
	public Partida salvarPartida(@RequestBody Partida partida) {
		
		return partidaServiceImpl.guardarPartida(partida);
	}
	
	
	//Se puede actualizar la partida para cambiar su nombre o el juego al que se jugara
	@PutMapping("/partida/{id}")
	public Partida actualizarPartida(@PathVariable(name="id")int id,@RequestBody Partida Partida) {
		
		Partida Partida_seleccionado;
		Partida Partida_actualizado;
		
		Partida_seleccionado= partidaServiceImpl.partidaXID(id);
		
		Partida_seleccionado.setNombre(Partida.getNombre());
		Partida_seleccionado.setJuego(Partida.getJuego());
		
		Partida_actualizado = partidaServiceImpl.actualizarPartida(Partida_seleccionado);
		
		System.out.println("La partida actualizada es: "+ Partida_actualizado);
		
		return Partida_actualizado;
	}
	
	//Se puede eliminar una partida que ya no se vaya a utilizar mas
	@DeleteMapping("/partida/{id}")
	public void eleiminarPartida(@PathVariable(name="id")int id) {
		partidaServiceImpl.eliminarPartida(id);
	}
	
	//Buscar partida por juego
	@GetMapping("/partida/juego/{juego}")
	public List<Partida> listarPartidaJuego(@PathVariable(name="id_juego") String juego) {
	    return partidaServiceImpl.listarPartidaJuego(juego);
	}
	
}
