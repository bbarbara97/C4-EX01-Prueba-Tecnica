package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMensajeDAO;
import com.example.demo.dto.Mensaje;

@Service
public class MensajeServiceImpl implements IMensajeService{

	@Autowired
	IMensajeDAO iMensajeDAO;

	@Override
	public List<Mensaje> listarMensaje() {
		return iMensajeDAO.findAll();
	}

	@Override
	public Mensaje guardarMensaje(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}

	@Override
	public Mensaje mensajeXID(int id) {
		return iMensajeDAO.findById(id).get();
	}

	@Override
	public Mensaje actualizarMensaje(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}

	@Override
	public void eliminarMensaje(int id) {
		iMensajeDAO.deleteById(id);
	}
}
