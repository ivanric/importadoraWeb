package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.ILineaDAO;
import com.infinito.importadoraWeb.model.Linea;

@Service
public class LineaServiceImpl implements ILineaService{

	@Autowired
	ILineaDAO lineadao;
	
	@Override
	public List<Map<String, Object>> ListaLinea(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return lineadao.ListaLineas(start, estado, search, length);
	}

	@Override
	public Linea obtener(int id) {
		// TODO Auto-generated method stub
		return lineadao.obtener(id);
	}

	@Override
	public boolean adicionar(Linea lin) {
		// TODO Auto-generated method stub
		return lineadao.adicionar(lin);
	}

	@Override
	public boolean modificar(Linea lin) {
		// TODO Auto-generated method stub
		return lineadao.modificar(lin);
	}

	@Override
	public boolean eliminar(int idlinea, int estado) {
		// TODO Auto-generated method stub
		return lineadao.eliminar(idlinea, estado);
	}

	@Override
	public Linea obtenernombre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linea> ListaLinea1() {
		// TODO Auto-generated method stub
		return lineadao.ListaLineas1();
	}

	@Override
	public Linea getLinea(int idlinea) {
		// TODO Auto-generated method stub
		return lineadao.getLinea(idlinea);
	}

	
}
