package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Juego;

public interface IJuegoService {

	//Metodos del CRUD
			public List<Juego> listarJuego(); //Listar All 
			
			public Juego guardarJuego(Juego juego);	//Guarda un Estudiante CREATE
			
			public Juego juegoXID(int id); //Leer datos de un Estudiante READ
			
			public Juego actualizarJuego(Juego juego); //Actualiza datos del estudiante UPDATE
			
			public void eliminarJuego(int id);// Elimina el estudiante DELETE
}
