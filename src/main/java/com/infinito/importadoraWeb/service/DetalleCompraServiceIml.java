package com.infinito.importadoraWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IDetalleCompraDAO;
import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Detallecompra;

@Service
public class DetalleCompraServiceIml implements IDetalleCompraService{

	@Autowired
	IDetalleCompraDAO dcompradao;
	
	@Override
	public List<Detallecompra> ListaDcompras(int id) {
		// TODO Auto-generated method stub
		return dcompradao.ListaDcompras(id);
	}

	@Override
	public Detallecompra getDetallecompra(int iddcomp) {
		// TODO Auto-generated method stub
		return dcompradao.getDetallecompra(iddcomp);
	}

	
}
