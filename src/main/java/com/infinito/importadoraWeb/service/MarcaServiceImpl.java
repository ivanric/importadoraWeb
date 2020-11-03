package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IMarcaDAO;
import com.infinito.importadoraWeb.model.Marca;

@Service
public class MarcaServiceImpl implements IMarcaService{

	@Autowired
	IMarcaDAO marcadao;

	@Override
	public List<Map<String, Object>> ListaMarcas(int start, int estado, String search, int length) {
		// TODO Auto-generated method stub
		return marcadao.ListaMarca(start, estado, search, length);
	}

	@Override
	public Marca obtener(int id) {
		// TODO Auto-generated method stub
		return marcadao.obtener(id);
	}

	@Override
	public boolean adicionar(Marca marc) {
		// TODO Auto-generated method stub
		return marcadao.adicionar(marc);
	}

	@Override
	public boolean modificar(Marca marc) {
		// TODO Auto-generated method stub
		return marcadao.modificar(marc);
	}

	@Override
	public boolean eliminar(int idmarc, int estado) {
		// TODO Auto-generated method stub
		return marcadao.eliminar(idmarc, estado);
	}

	@Override
	public Marca obtenernombre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> ListaMarcas1() {
		// TODO Auto-generated method stub
		return marcadao.ListaMarcas1();
	}

	@Override
	public Marca obteneridmod(int id) {
		// TODO Auto-generated method stub
		return marcadao.obteneridmod(id);
	}

	@Override
	public Marca getMarca(int idmarc) {
		// TODO Auto-generated method stub
		return marcadao.getMarca(idmarc);
	}

	@Override
	public Marca obtenerMarca(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> listaporitem() {
		// TODO Auto-generated method stub
		return marcadao.listaporitem();
	}

	
}
