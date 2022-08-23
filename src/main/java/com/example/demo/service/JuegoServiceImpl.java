package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IJuegoDAO;
import com.example.demo.dto.Juego;

@Service
public class JuegoServiceImpl implements IJuegoService{

	@Autowired
	IJuegoDAO iJuegoDAO;

	@Override
	public List<Juego> listarJuego() {
		return iJuegoDAO.findAll();
	}

	@Override
	public Juego guardarJuego(Juego juego) {
		return iJuegoDAO.save(juego);
	}

	@Override
	public Juego juegoXID(int id) {
		return iJuegoDAO.findById(id).get();
	}

	@Override
	public Juego actualizarJuego(Juego juego) {
		return iJuegoDAO.save(juego);
	}

	@Override
	public void eliminarJuego(int id) {
		iJuegoDAO.deleteById(id);
	}
}
