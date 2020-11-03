package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;


import com.infinito.importadoraWeb.model.Linea;

public interface ILineaService {


	public List<Map<String, Object>> ListaLinea(int start,int estado, String search, int length);
	public Linea obtener(int id);
	
	
	public boolean adicionar(Linea lin);
	public boolean modificar(Linea lin);
	public boolean eliminar(int idlinea,int estado);
	public Linea obtenernombre(int id);
	public List<Linea> ListaLinea1();
	public Linea getLinea(int idlinea);
}
