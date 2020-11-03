package com.infinito.importadoraWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IArticuloDAO;
import com.infinito.importadoraWeb.model.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	IArticuloDAO artdao;
	
	@Override
	public Articulo getArticulo(int idart) {
		// TODO Auto-generated method stub
		System.out.println("llego al servicio ");
		return artdao.getArticulo(idart);
	}

	@Override
	public Articulo obtenerArt(int idart) {
		System.out.println("llego al servicio ");
		return artdao.obtenerArt(idart);
	}

	@Override
	public boolean validarexistenciachasis(String validar) {
		// TODO Auto-generated method stub
		return artdao.validarexistenciachasis(validar);
	}

	@Override
	public boolean validarexistenciamotor(String validar) {
		// TODO Auto-generated method stub
		return artdao.validarexistenciamotor(validar);
	}

	
}
