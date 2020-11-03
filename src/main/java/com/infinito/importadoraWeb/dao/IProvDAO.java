package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Pais;
import com.infinito.importadoraWeb.model.Provincia;

public interface IProvDAO {

	public List<Map<String, Object>> ListaProvincia(int start,int estado, String search, int length);
	public Provincia obtener(int id);
	public boolean adicionar(String nombre, int iddep);
	public boolean modificar(Provincia prov);
	public boolean eliminar(int idprov,int estado);
	public Pais obtenerPais(int iddep);
}
