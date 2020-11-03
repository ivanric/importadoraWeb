package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.ICategoriaDAO;
import com.infinito.importadoraWeb.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	 
	@Autowired
	ICategoriaDAO catdao;

	@Override
	public List<Map<String, Object>> ListaCategoria(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return catdao.ListaCategorias(start, estado, search, length);
	}

	@Override
	public Categoria obtener(int id) {
		// TODO Auto-generated method stub
		return catdao.obtener(id);
	}

	@Override
	public boolean adicionar(Categoria cat) {
		// TODO Auto-generated method stub
		return catdao.adicionar(cat);
	}

	@Override
	public boolean modificar(Categoria cat) {
		// TODO Auto-generated method stub
		return catdao.modificar(cat);
	}

	@Override
	public boolean eliminar(int idcat, int estado) {
		// TODO Auto-generated method stub
		return catdao.eliminar(idcat, estado);
	}

	@Override
	public Categoria obtenernombre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> ListaCategoria1() {
		// TODO Auto-generated method stub
		return catdao.ListaCategorias1();
	}

	@Override
	public Categoria getcategoria(int idcate) {
		// TODO Auto-generated method stub
		return catdao.getcategoria(idcate);
	}
	
	
}
