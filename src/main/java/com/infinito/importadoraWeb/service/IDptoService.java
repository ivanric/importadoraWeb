package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Departamento;
import com.infinito.importadoraWeb.model.Pais;

public interface IDptoService {
	public List<Map<String, Object>> ListaDpto(int start,int estado, String search, int length);
	public Departamento obtener(int id);
	public boolean adicionar(String nombre, int idpais);
	public boolean modificar(Departamento dpto);
	public boolean eliminar(int iddep,int estado);
	public List<Map<String, Object>> ListaDpto();
	public Departamento obtenernombre(int iddep);
	public List<?> ListaDptoid(Integer idpais);
}
