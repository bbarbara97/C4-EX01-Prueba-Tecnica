package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Grupo;

public interface IGrupoService {

	//Metodos del CRUD
			public List<Grupo> listarGrupos(); //Listar All 
			
			public Grupo guardarGrupo(Grupo grupo);	//Guarda un RegistroCurso CREATE
			
			public Grupo grupoXID(int id); //Leer datos de un RegistroCurso READ
			
			public Grupo actualizarGrupo(Grupo grupo); //Actualiza datos del RegistroCurso UPDATE
			
			public void eliminarGrupo(int id);// Elimina el RegistroCurso DELETE
}
