package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Partida;

public interface IPartidaDAO extends JpaRepository<Partida, Integer>{

	public List<Partida> findByJuego(String juego);
}
