package com.infinito.importadoraWeb.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IColorDAO;
import com.infinito.importadoraWeb.model.Color;


@Service
public class ColorServiceImpl implements IColorService{

	@Autowired
	IColorDAO colodao;
	
	@Override
	public List<Map<String, Object>> ListaColores(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return colodao.ListaColores( start,estado, search,  length);
	}

	@Override
	public Color obtener(int id) {
		// TODO Auto-generated method stub
		return colodao.obtener(id);
	}

	@Override
	public boolean adicionar(Color color) {
		// TODO Auto-generated method stub
		return colodao.adicionar(color);
	}

	@Override
	public boolean modificar(Color color) {
		// TODO Auto-generated method stub
		return colodao.modificar(color);
	}

	@Override
	public boolean eliminar(int idcolor, int estado) {
		// TODO Auto-generated method stub
		return colodao.eliminar(idcolor, estado);
	}

	@Override
	public Color obtenernombre(int id) {
		// TODO Auto-generated method stub
		return colodao.obtenernombre(id);
	}

	@Override
	public List<Color> ListaColores() {
		// TODO Auto-generated method stub
		return colodao.ListaColores1();
	}

	@Override
	public Color getColor(int idcolor) {
		// TODO Auto-generated method stub
		return colodao.getcolor(idcolor);
	}

	@Override
	public List<Color> listarporItemIdColor(int idmod) {
		// TODO Auto-generated method stub
		return colodao.listarporItemIdColor(idmod);
	}

}
