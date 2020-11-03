package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.ICompraDAO;
import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Marca;
import com.infinito.importadoraWeb.model.Modelo;

@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	ICompraDAO compradao;
	
	@Override
	public List<Map<String, Object>> ListaCompras(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return compradao.ListaCompras(start, estado, search, length);
	}

	@Override
	public Compra obtener(int id) {
		// TODO Auto-generated method stub
		return compradao.obtener(id);
	}

	@Override
	public List<Compra> ListaDcompras(int id) {
		// TODO Auto-generated method stub
		return compradao.listaDcompras(id);
	}

	@Override
	public Marca obtenerMarca(int id) {
		// TODO Auto-generated method stub
		return compradao.obtenerMarca(id);
	}

	@Override
	public Modelo obtenerModelo(int id) {
		// TODO Auto-generated method stub
		return compradao.obtenerModelo(id);
	}

	@Override
	public Compra getcompra(int idcomp) {
		// TODO Auto-generated method stub
		return compradao.getcompra(idcomp);
	}

}
