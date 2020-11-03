package com.infinito.importadoraWeb.service;

import java.util.List;


import com.infinito.importadoraWeb.model.Detallecompra;;

public interface IDetalleCompraService {
	
	public List<Detallecompra> ListaDcompras(int id);
	public Detallecompra getDetallecompra(int iddcomp);

}
