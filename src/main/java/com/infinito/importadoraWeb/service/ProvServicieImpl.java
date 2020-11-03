package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IProvDAO;
import com.infinito.importadoraWeb.model.Pais;
import com.infinito.importadoraWeb.model.Provincia;

@Service
public class ProvServicieImpl implements IProvService{

	@Autowired
	IProvDAO provdao;
	
	@Override
	public List<Map<String, Object>> ListaProvincia(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return provdao.ListaProvincia(start, estado, search, length);
	}

	@Override
	public Provincia obtener(int id) {
		// TODO Auto-generated method stub
		return provdao.obtener(id);
	}

	@Override
	public boolean adicionar(String nombre, int iddep) {
		// TODO Auto-generated method stub
		return provdao.adicionar(nombre, iddep);
	}

	@Override
	public boolean modificar(Provincia prov) {
		// TODO Auto-generated method stub
		return provdao.modificar(prov);
	}

	@Override
	public boolean eliminar(int idprov, int estado) {
		// TODO Auto-generated method stub
		return provdao.eliminar(idprov, estado);
	}

	@Override
	public Pais obtenerPais(int iddep) {
		// TODO Auto-generated method stub
		return provdao.obtenerPais(iddep);
	}

}
