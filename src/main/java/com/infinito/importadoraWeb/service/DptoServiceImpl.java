package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IDptoDAO;
import com.infinito.importadoraWeb.model.Departamento;

@Service
public class DptoServiceImpl implements IDptoService{

	@Autowired
	private IDptoDAO dptoDao;
	
	@Override
	public List<Map<String, Object>> ListaDpto(int start, int estado, String search, int length) {
		return dptoDao.lista(start, estado, search, length);
	}

	@Override
	public Departamento obtener(int id) {
		// TODO Auto-generated method stub
		return dptoDao.obtener(id);
	}

	@Override
	public boolean adicionar(String nombre,int idpais) {
		// TODO Auto-generated method stub
		return dptoDao.adicionar(nombre,idpais);
	}

	@Override
	public boolean modificar(Departamento dpto) {
		// TODO Auto-generated method stub
		return dptoDao.modificar(dpto);
	}

	@Override
	public boolean eliminar(int iddep, int estado) {
		// TODO Auto-generated method stub
		return dptoDao.eliminar(iddep, estado);
	}

	@Override
	public List<Map<String, Object>> ListaDpto() {
		// TODO Auto-generated method stub
		return dptoDao.ListDpto();
	}

	@Override
	public Departamento obtenernombre(int iddep) {
		// TODO Auto-generated method stub
		return dptoDao.obtenernombre(iddep);
	}

	@Override
	public List<?> ListaDptoid(Integer idpais) {
		// TODO Auto-generated method stub
		return dptoDao.ListDptoid(idpais);
	}

	
}
