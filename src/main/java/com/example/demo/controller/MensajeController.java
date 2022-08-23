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

import com.example.demo.dto.Mensaje;
import com.example.demo.service.MensajeServiceImpl;

@RestController
@RequestMapping("/api")
public class MensajeController {

	@Autowired
	MensajeServiceImpl mensajeServiceImpl;
	
	@GetMapping("/mensaje")
	public List<Mensaje> listarMensaje(){
		return mensajeServiceImpl.listarMensaje();
	}
	
	//añadir un mensaje
	@PostMapping("/mensaje")
	public Mensaje salvarMensaje(@RequestBody Mensaje mensaje) {
		
		return mensajeServiceImpl.guardarMensaje(mensaje);
	}
	
	//Modificar un mensaje
	@PutMapping("/mensaje/{id}")
	public Mensaje actualizarMensaje(@PathVariable(name="id")int id,@RequestBody Mensaje Mensaje) {
		
		Mensaje Mensaje_seleccionado;
		Mensaje Mensaje_actualizado;
		
		Mensaje_seleccionado= mensajeServiceImpl.mensajeXID(id);
		
		Mensaje_seleccionado.setContenido(Mensaje.getContenido());
		Mensaje_seleccionado.setPartida(Mensaje.getPartida());
		Mensaje_seleccionado.setUsuario(Mensaje.getUsuario());
		
		Mensaje_actualizado = mensajeServiceImpl.actualizarMensaje(Mensaje_seleccionado);
		
		System.out.println("El mensaje actualizado es: "+ Mensaje_actualizado);
		
		return Mensaje_actualizado;
	}
	
	//Eliminar un mensaje
	@DeleteMapping("/mensaje/{id}")
	public void eleiminarMensaje(@PathVariable(name="id")int id) {
		mensajeServiceImpl.eliminarMensaje(id);
	}
	
}
