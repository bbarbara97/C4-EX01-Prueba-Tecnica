package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Mensaje;

public interface IMensajeService {

	//Metodos del CRUD
			public List<Mensaje> listarMensaje(); //Listar All 
			
			public Mensaje guardarMensaje(Mensaje mensaje);	//Guarda un Estudiante CREATE
			
			public Mensaje mensajeXID(int id); //Leer datos de un Estudiante READ
			
			public Mensaje actualizarMensaje(Mensaje mensaje); //Actualiza datos del estudiante UPDATE
			
			public void eliminarMensaje(int id);// Elimina el estudiante DELETE
}
