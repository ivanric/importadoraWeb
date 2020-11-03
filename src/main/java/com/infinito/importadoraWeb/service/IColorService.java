package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Color;


public interface IColorService {

	public List<Map<String, Object>> ListaColores(int start,int estado, String search, int length);
	public Color obtener(int id);
	
	
	public boolean adicionar(Color color);
	public boolean modificar(Color color);
	public boolean eliminar(int idcolor,int estado);
	public Color obtenernombre(int id);
	public List<Color> ListaColores();
	public Color getColor(int idcolor);
	public List<Color> listarporItemIdColor(int idmod);
}
