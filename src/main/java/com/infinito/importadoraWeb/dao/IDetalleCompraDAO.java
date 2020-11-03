package com.infinito.importadoraWeb.dao;

import java.util.List;

import com.infinito.importadoraWeb.model.Detallecompra;

public interface IDetalleCompraDAO {

	public List<Detallecompra> ListaDcompras(int id);
	public Detallecompra getDetallecompra(int iddcomp);
}
