package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IGrupoDAO;
import com.example.demo.dto.Grupo;

@Service
public class GrupoServiceImpl implements IGrupoService{

	@Autowired
	IGrupoDAO iGrupoDAO;

	@Override
	public List<Grupo> listarGrupos() {
		return iGrupoDAO.findAll();
	}

	@Override
	public Grupo guardarGrupo(Grupo grupo) {
		return iGrupoDAO.save(grupo);
	}

	@Override
	public Grupo grupoXID(int id) {
		return iGrupoDAO.findById(id).get();
	}

	@Override
	public Grupo actualizarGrupo(Grupo grupo) {
		return iGrupoDAO.save(grupo);
	}

	@Override
	public void eliminarGrupo(int id) {
		iGrupoDAO.deleteById(id);
	}
}
