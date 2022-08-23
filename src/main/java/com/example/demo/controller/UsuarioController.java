package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Usuario;
import com.example.demo.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;	
	
	//Creacion de usuarios
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	//para comprobar los datos de un usuario
	@GetMapping("/usuario/{id}")
	public Usuario UsuarioXID(@PathVariable(name="id") int id) {	
		return usuarioServiceImpl.usuarioXID(id);
	}
	
	//Actualizacion de usuarios
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuario(@PathVariable(name="id")int id,@RequestBody Usuario Usuario) {
		
		Usuario Usuario_seleccionado;
		Usuario Usuario_actualizado;
		
		Usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		Usuario_seleccionado.setUsername(Usuario.getUsername());
		Usuario_seleccionado.setPassword(Usuario.getPassword());
		Usuario_seleccionado.setEmail(Usuario.getEmail());
		Usuario_seleccionado.setSteam_user(Usuario.getSteam_user());
		
		Usuario_actualizado = usuarioServiceImpl.actualizarUsuario(Usuario_seleccionado);
		
		System.out.println("El usuario actualizado es: "+ Usuario_actualizado);
		
		return Usuario_actualizado;
	}
	
	//Eliminacion de usuario por si se quiere borrar la cuenta
	@DeleteMapping("/usuario/{id}")
	public void eleiminarUsuario(@PathVariable(name="id")int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}
