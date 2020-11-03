package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Departamento;
import com.infinito.importadoraWeb.model.Pais;

public interface IDptoDAO {


	public List<Map<String, Object>> lista(int start,int estado,String search,int length);
	public Departamento obtener(int id);
	public boolean adicionar(String nombre,int idpais);
	public boolean modificar(Departamento dpto);
	public boolean eliminar(int iddep,int estado);
	public List<Map<String, Object>> ListDpto();
	public Departamento obtenernombre(int iddep);
	public List<?> ListDptoid(Integer idpais);

}
