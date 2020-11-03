package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Marca;
import com.infinito.importadoraWeb.model.Modelo;

public interface ICompraDAO {

	public List<Map<String, Object>> ListaCompras(int start,int estado, String search, int length);

	public Compra obtener(int id);

	public List<Compra> listaDcompras(int id);

	public Marca obtenerMarca(int id);

	public Modelo obtenerModelo(int id);

	public Compra getcompra(int idcomp);

}
