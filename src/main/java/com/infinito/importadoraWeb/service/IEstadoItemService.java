package com.infinito.importadoraWeb.service;

import java.util.List;

import com.infinito.importadoraWeb.model.Estadoitem;

public interface IEstadoItemService {

	public Estadoitem getEstaItem(int idestaitem);

	public List<Estadoitem> listar();
}
