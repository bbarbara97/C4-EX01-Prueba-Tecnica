package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPartidaDAO;
import com.example.demo.dto.Partida;

@Service
public class PartidaServiceImpl implements IPartidaService{

	@Autowired
	IPartidaDAO iPartidaDAO;

	@Override
	public List<Partida> listarPartida() {
		return iPartidaDAO.findAll();
	}

	@Override
	public Partida guardarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}

	@Override
	public Partida partidaXID(int id) {
		return iPartidaDAO.findById(id).get();
	}

	@Override
	public Partida actualizarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}

	@Override
	public void eliminarPartida(int id) {
		iPartidaDAO.deleteById(id);
	}
	
	@Override
	public List<Partida> listarPartidaJuego(String juego) {
		
		return iPartidaDAO.findByJuego(juego);
	}
}
