package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Color;

public interface IColorDAO {

	public List<Map<String, Object>> ListaColores(int start,int estado, String search, int length);
	public Color obtener(int id);
	public boolean adicionar(Color color);
	public boolean modificar(Color color);
	public boolean eliminar(int idcolor,int estado);
	public Color obtenernombre(int id);
	public List<Color> ListaColores1();
	public Color getcolor(int idcolor);
	public List<Color> listarporItemIdColor(int idmod);
}
