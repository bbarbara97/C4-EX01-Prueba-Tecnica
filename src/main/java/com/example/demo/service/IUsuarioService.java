package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Usuario;

public interface IUsuarioService {

	//Metodos del CRUD
			public List<Usuario> listarUsuario(); //Listar All 
			
			public Usuario guardarUsuario(Usuario usuario);	//Guarda un Estudiante CREATE
			
			public Usuario usuarioXID(int id); //Leer datos de un Estudiante READ
			
			public Usuario actualizarUsuario(Usuario usuario); //Actualiza datos del estudiante UPDATE
			
			public void eliminarUsuario(int id);// Elimina el estudiante DELETE
}
