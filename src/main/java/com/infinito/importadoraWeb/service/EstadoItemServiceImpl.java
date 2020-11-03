package com.infinito.importadoraWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IEstadoItemDAO;
import com.infinito.importadoraWeb.model.Estadoitem;

@Service
public class EstadoItemServiceImpl implements IEstadoItemService{

	@Autowired
	IEstadoItemDAO estaitemdao;
	
	@Override
	public Estadoitem getEstaItem(int idestaitem) {
		// TODO Auto-generated method stub
		return estaitemdao.getEstadoItem(idestaitem);
	}

	@Override
	public List<Estadoitem> listar() {
		// TODO Auto-generated method stub
		return estaitemdao.listar();
	}

	
}
