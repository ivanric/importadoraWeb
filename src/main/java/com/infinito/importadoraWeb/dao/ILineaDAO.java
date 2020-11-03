package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Linea;



public interface ILineaDAO {


	public List<Map<String, Object>> ListaLineas(int start,int estado, String search, int length);
	public Linea obtener(int id);
	
	
	public boolean adicionar(Linea linea);
	public boolean modificar(Linea linea);
	public boolean eliminar(int idlinea,int estado);
	public Linea obtenernombre(int id);
	public List<Linea> ListaLineas1();
	public Linea getLinea(int idlinea);
}
