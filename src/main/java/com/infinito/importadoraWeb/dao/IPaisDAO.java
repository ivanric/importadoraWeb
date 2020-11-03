package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.infinito.importadoraWeb.model.Pais;

public interface IPaisDAO {
	
	public List<Map<String, Object>> lista(int start,int estado,String search,int length);
	public Pais obtener(int id);
	public boolean adicionar(Pais pais);
	public boolean modificar(Pais pais);
	public boolean eliminar(int idpais,int estado);
	public Pais obtenernombre(int id);
	public List<Map<String, Object>> lista();
}
