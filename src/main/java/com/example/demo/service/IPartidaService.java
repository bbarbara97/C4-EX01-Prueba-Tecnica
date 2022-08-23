package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Partida;

public interface IPartidaService {

	//Metodos del CRUD
			public List<Partida> listarPartida(); //Listar All 
			
			public Partida guardarPartida(Partida partida);	//Guarda un Estudiante CREATE
			
			public Partida partidaXID(int id); //Leer datos de un Estudiante READ
			
			public List<Partida> listarPartidaJuego(String juego); //Listar por juego
			
			public Partida actualizarPartida(Partida partida); //Actualiza datos del estudiante UPDATE
			
			public void eliminarPartida(int id);// Elimina el estudiante DELETE
}
