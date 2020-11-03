package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IModelosDAO;
import com.infinito.importadoraWeb.model.Modelo;

@Service
public class ModeloServiceImpl implements IModeloService{

	@Autowired
	IModelosDAO modleodao;

	@Override
	public List<Map<String, Object>> ListaModelos(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return modleodao.ListaModelos(start, estado, search, length);
	}

	@Override
	public Modelo obtener(int id) {
		// TODO Auto-generated method stub
		return modleodao.obtener(id);
	}

	@Override
	public boolean adicionar(Modelo mod) {
		// TODO Auto-generated method stub
		return modleodao.adicionar(mod);
	}

	@Override
	public boolean modificar(Modelo mod) {
		// TODO Auto-generated method stub
		return modleodao.modificar(mod);
	}

	@Override
	public boolean eliminar(int idmod, int estado) {
		// TODO Auto-generated method stub
		return modleodao.eliminar(idmod, estado);
	}

	@Override
	public Modelo obtenernombre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> ListaModelos1() {
		// TODO Auto-generated method stub
		return modleodao.ListaModelos1();
	}

	@Override
	public List<Modelo> ListaModelos(int idmarc) {
		// TODO Auto-generated method stub
		return modleodao.ListaModelos(idmarc);
	}

	@Override
	public Modelo getModelo(int idmod) {
		// TODO Auto-generated method stub
		return modleodao.getModelo(idmod);
	}

	@Override
	public List<Modelo> listarporItemIdMarca(int idmarc) {
		// TODO Auto-generated method stub
		return modleodao.listarporItemIdMarca(idmarc);
	}
	
}
