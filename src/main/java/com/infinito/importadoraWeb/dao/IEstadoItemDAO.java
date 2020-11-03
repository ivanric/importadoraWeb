package com.infinito.importadoraWeb.dao;

import java.util.List;

import com.infinito.importadoraWeb.model.Estadoitem;

public interface IEstadoItemDAO {
	
	public Estadoitem getEstadoItem(int idestaitem);

	public List<Estadoitem> listar();

}
